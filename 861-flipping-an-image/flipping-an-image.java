class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image[0].length;  //how many columns in a first row ==//image.length-no.of rows
        for(int[]row:image){
            int low=0;
            int high=n-1;;
            while(low<=high){
                // Flip and invert at the same time
                int temp=row[low];
                row[low]=1-row[high];
                row[high]=1-temp;
                low++;
                high--;
            }
        }
        return image;
           }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna