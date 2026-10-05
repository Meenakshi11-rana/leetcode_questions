class Solution {
    public String defangIPaddr(String address) {
        //Approach 1
        return address.replace(".","[.]");
        
        //Approach 2
    //     String temp = "";

    //     for (int i = 0; i < address.length(); i++) {

    //         if (address.charAt(i) == '.') {
    //             temp = temp + "[.]";
    //         } else {
    //             temp = temp + address.charAt(i);
    //         }
    //     }

    //     return temp; 
     }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna