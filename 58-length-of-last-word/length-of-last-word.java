class Solution {
    public int lengthOfLastWord(String s) {
    //     int i = s.length() - 1;

    //     // Skip spaces at the end
    //     while (i >= 0 && s.charAt(i) == ' ') {
    //         i--;
    //     }

    //     int length = 0;

    //     // Count the last word
    //     while (i >= 0 && s.charAt(i) != ' ') {
    //         length++;
    //         i--;
    //     }

    //     return length;
        // s = s.trim();

        // int lastSpace = s.lastIndexOf(" ");

        // return s.length() - lastSpace - 1;
        String[] words=s.trim().split(" ");
        return words[words.length-1].length();
            }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna