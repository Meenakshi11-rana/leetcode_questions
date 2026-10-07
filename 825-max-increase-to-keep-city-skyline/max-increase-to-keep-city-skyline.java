class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int n = grid.length;

        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // Find maximum of every row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }

        // Find maximum of every column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int totalIncrease = 0;

        // Calculate maximum possible increase
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int maxHeight = Math.min(rowMax[i], colMax[j]);

                totalIncrease += maxHeight - grid[i][j];
            }
        }

        return totalIncrease;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna