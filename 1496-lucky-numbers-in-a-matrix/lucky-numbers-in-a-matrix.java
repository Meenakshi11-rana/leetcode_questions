import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {


            int min = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                min = Math.min(min, matrix[i][j]);
            }

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == min) {

                    int max = Integer.MIN_VALUE;

                    for (int k = 0; k < n; k++) {
                        max = Math.max(max, matrix[k][j]);
                    }

                    if (matrix[i][j] == max) {
                        ans.add(matrix[i][j]);
                    }
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna