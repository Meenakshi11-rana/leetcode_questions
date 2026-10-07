import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int total = 0;

        // Group elements according to i + j
        for (int i = 0; i < nums.size(); i++) {

            for (int j = 0; j < nums.get(i).size(); j++) {

                int diagonal = i + j;

                map.putIfAbsent(diagonal, new ArrayList<>());

                map.get(diagonal).add(nums.get(i).get(j));

                total++;
            }
        }

        int[] ans = new int[total];
        int index = 0;

        // Process diagonals
        for (int d = 0; d <= total; d++) {

            if (!map.containsKey(d)) {
                continue;
            }

            List<Integer> list = map.get(d);

            // Reverse order
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[index++] = list.get(i);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna