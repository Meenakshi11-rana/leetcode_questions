class Solution {
    public String restoreString(String s, int[] indices) {
        //Approach 1
        // char[] ans= new char[s.length()];
        // for(int i=0;i<s.length();i++){
        //     ans[indices[i]]=s.charAt(i);
        // }
        // return new String(ans);

        //Approach 2
         char[] res=new char[s.length()];
        int i=0;
        for(int n:indices)  res[n]=s.charAt(i++);
        return new String(res);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna