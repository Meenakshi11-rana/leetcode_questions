class Solution {
public int minMoves2(int[] nums) {
Arrays.sort(nums);
int n = nums.length;
int mid = nums[n / 2];
int total = 0;

for (int num : nums) {
total += Math.abs(num - mid);
}

return total;
}
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna