class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //APPROACH 1
        // String s1="";
        // String s2="";
        // for(int i=0;i<word1.length;i++){
        //     s1=s1+word1[i];
        // }
        // for(int i=0;i<word2.length;i++){
        //     s2=s2+word2[i];
        // }
        // return s1.equals(s2);


        //APPROACH 2
        // String s1=String.join("",word1);
        // String s2=String.join("",word2);
        // return s1.equals(s2);

        //APPROACH 3
        return String.join("", word1).equals(String.join("", word2));
    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna