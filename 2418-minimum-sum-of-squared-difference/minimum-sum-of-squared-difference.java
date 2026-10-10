class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;
        long totalOps = (long) k1 + k2;
        long sumDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sumDiff += diff[i];
        }

        if (totalOps >= sumDiff) {
            return 0;
        }

        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && totalOps > 0; d--) {
            if (freq[d] <= totalOps) {
                totalOps -= freq[d];
                freq[d - 1] += freq[d];
                freq[d] = 0;
            } else {
                freq[d - 1] += (int) totalOps;
                freq[d] -= (int) totalOps;
                totalOps = 0;
            }
        }

        long answer = 0;

        for (int d = 1; d < freq.length; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna