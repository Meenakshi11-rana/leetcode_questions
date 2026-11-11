class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Strategy 1: Buy all required items individually
        long buyIndividually = (long) need1 * cost1 + (long) need2 * cost2;

        // Strategy 2: Buy combo packs to cover the maximum requirement
        long buyAllCombo = (long) costBoth * Math.max(need1, need2);

        // Strategy 3: Buy combo packs for overlapping needs, then buy the rest individually
        int overlap = Math.min(need1, need2);
        long buyMixed = (long) costBoth * overlap 
                      + (long) (need1 - overlap) * cost1 
                      + (long) (need2 - overlap) * cost2;

        return Math.min(buyIndividually, Math.min(buyAllCombo, buyMixed));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna