import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {

            // Find minimum in this row
            int rowMin = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }

            // Check every element in this row
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == rowMin) {

                    // Find maximum in this column
                    int colMax = Integer.MIN_VALUE;

                    for (int k = 0; k < n; k++) {
                        colMax = Math.max(colMax, matrix[k][j]);
                    }

                    // Lucky number
                    if (matrix[i][j] == colMax) {
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