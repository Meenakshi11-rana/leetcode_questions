class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0, count = 0;

        while (i < arr1.length) {
            while (j < arr2.length && arr2[j] < arr1[i] - d) {
                j++;
            }

            if (j == arr2.length || arr2[j] > arr1[i] + d) {
                count++;
            }

            i++;
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna