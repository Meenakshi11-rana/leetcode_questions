class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // A valid path must have even length
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // dp[i][j] contains possible balance values
        boolean[][][] dp = new boolean[m][n][m + n];

        if (grid[0][0] == '(') {
            dp[0][0][1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int balance = 0; balance < m + n; balance++) {

                    if (!dp[i][j][balance]) {
                        continue;
                    }

                    // Move down
                    if (i + 1 < m) {
                        int next = balance + (grid[i + 1][j] == '(' ? 1 : -1);

                        if (next >= 0) {
                            dp[i + 1][j][next] = true;
                        }
                    }

                    // Move right
                    if (j + 1 < n) {
                        int next = balance + (grid[i][j + 1] == '(' ? 1 : -1);

                        if (next >= 0) {
                            dp[i][j + 1][next] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna