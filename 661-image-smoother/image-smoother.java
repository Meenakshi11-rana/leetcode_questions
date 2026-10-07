class Solution {
    public int[][] imageSmoother(int[][] img) {

        int m = img.length;
        int n = img[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int sum = 0;
                int count = 0;

                // Check all 9 positions
                for (int r = i - 1; r <= i + 1; r++) {

                    for (int c = j - 1; c <= j + 1; c++) {

                        // Check if position is inside matrix
                        if (r >= 0 && r < m && c >= 0 && c < n) {

                            sum += img[r][c];
                            count++;
                        }
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna