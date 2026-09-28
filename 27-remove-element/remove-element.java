class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int n:nums){
            if(n!=val){
                nums[count++]=n;
            }
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna