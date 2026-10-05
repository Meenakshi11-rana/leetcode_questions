class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ans= new char[s.length()];
        for(int i=0;i<s.length();i++){
            ans[indices[i]]=s.charAt(i);
        }
        return new String(ans);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna