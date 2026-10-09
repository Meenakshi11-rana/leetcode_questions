class Solution {
    public int minInsertions(String s) {
        int need = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // If need is odd, insert one ')' first
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }

                // Every '(' requires two ')'
                need += 2;

            } else {
                need--;

                // No opening parenthesis is available
                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna