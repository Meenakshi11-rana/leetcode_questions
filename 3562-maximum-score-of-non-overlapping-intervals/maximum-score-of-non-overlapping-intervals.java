import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // [left, right, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by ending position
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[3], b[3]);
        });

        // Find previous non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int left = arr[i][0];

            int lo = 0;
            int hi = i - 1;
            int ans = -1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                // Strictly less because sharing a boundary means overlapping
                if (arr[mid][1] < left) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            prev[i] = ans;
        }

        /*
         * dp[i][k] = best selection using first i intervals
         * with at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State();
            }
        }

        for (int i = 1; i <= n; i++) {

            // Don't take interval i-1
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = better(dp[i][k], dp[i - 1][k]);
            }

            // Take interval i-1
            int idx = i - 1;

            for (int k = 1; k <= 4; k++) {

                int previous = prev[idx] + 1;

                State candidate = new State();
                candidate.score =
                        dp[previous][k - 1].score + arr[idx][2];

                candidate.indices =
                        new ArrayList<>(dp[previous][k - 1].indices);

                candidate.indices.add(arr[idx][3]);

                Collections.sort(candidate.indices);

                dp[i][k] = better(dp[i][k], candidate);
            }
        }

        State answer = dp[n][4];

        int[] result = new int[answer.indices.size()];

        for (int i = 0; i < answer.indices.size(); i++) {
            result[i] = answer.indices.get(i);
        }

        return result;
    }

    // Returns the better state:
    // 1. Higher score
    // 2. If same score, lexicographically smaller indices
    private State better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        List<Integer> x = a.indices;
        List<Integer> y = b.indices;

        int len = Math.min(x.size(), y.size());

        for (int i = 0; i < len; i++) {
            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i) ? a : b;
            }
        }

        return x.size() <= y.size() ? a : b;
    }

    static class State {
        long score = 0;
        List<Integer> indices = new ArrayList<>();
    }
}