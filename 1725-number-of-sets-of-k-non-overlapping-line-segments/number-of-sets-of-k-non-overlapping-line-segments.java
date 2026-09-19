class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        long[][] dp = new long[k + 1][n];

        // With 0 segments, there is 1 way.
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {
            long active = 0;

            for (int points = 1; points < n; points++) {

                // Start a new segment using the current point
                active = (active + dp[segments - 1][points - 1]) % MOD;

                // Ways without necessarily ending at current point
                dp[segments][points] =
                    (dp[segments][points - 1] + active) % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}