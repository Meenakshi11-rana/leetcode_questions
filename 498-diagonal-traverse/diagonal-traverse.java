class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int index = 0;

        int row = 0;
        int col = 0;

        boolean up = true;

        while (index < m * n) {

            ans[index++] = mat[row][col];

            if (up) {
                // Moving up-right
                if (col == n - 1) {
                    row++;
                    up = false;
                }
                else if (row == 0) {
                    col++;
                    up = false;
                }
                else {
                    row--;
                    col++;
                }

            } else {
                // Moving down-left
                if (row == m - 1) {
                    col++;
                    up = true;
                }
                else if (col == 0) {
                    row++;
                    up = true;
                }
                else {
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna