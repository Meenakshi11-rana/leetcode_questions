class Solution {
    public int minMoves(int[] nums) {

        int maxElement = 0;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += maxElement - num;
        }

        return moves;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna