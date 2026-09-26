class Solution {
    public int removeDuplicates(int[] nums) {
        // int k = 1;

        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[k - 1]) {
        //         nums[k] = nums[i];
        //         k++;
        //     }
        // }

        // return k;
        int prev = Integer.MIN_VALUE;
        int count=0;
        for(int n:nums){
            if(n!=prev){
                nums[count++]=n;
                prev=n;
            }
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna