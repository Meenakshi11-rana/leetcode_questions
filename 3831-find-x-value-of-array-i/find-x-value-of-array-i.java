class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];
            int value = num % k;

            // Start a new subarray
            next[value]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    int newRemainder = (r * value) % k;
                    next[newRemainder] += dp[r];
                }
            }

            // Add counts to the answer
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna