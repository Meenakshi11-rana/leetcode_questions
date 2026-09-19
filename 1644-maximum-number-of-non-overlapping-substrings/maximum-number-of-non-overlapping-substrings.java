import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Create valid intervals
        for (int c = 0; c < 26; c++) {

            if (last[c] == -1) {
                continue;
            }

            int left = first[c];
            int right = last[c];
            boolean valid = true;

            for (int i = left; i <= right; i++) {
                int current = s.charAt(i) - 'a';

                // This character occurs before our interval
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                // Expand interval to include all occurrences
                right = Math.max(right, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Choose maximum number of non-overlapping intervals
        // by sorting according to ending position.
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();
        int previousEnd = -1;

        for (int[] interval : intervals) {
            if (interval[0] > previousEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                previousEnd = interval[1];
            }
        }

        return result;
    }
}