import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // if (points.length == 0) {
        //     return 0;
        // }

        // Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // int arrows = 1;
        // int end = points[0][1];

        // for (int i = 1; i < points.length; i++) {
        //     if (points[i][0] > end) {
        //         arrows++;
        //         end = points[i][1];
        //     }
        // }

        // return arrows;

        
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int[] temp = points[0];
        int count = 0;

        for (int i = 1; i < points.length; i++) {
            if (temp[1] >= points[i][0]) {
                temp[0] = Math.max(temp[0], points[i][0]);
                temp[1] = Math.min(temp[1], points[i][1]);
            } else {
                count++;
                temp = points[i];
            }
        }

        count++;
        return count;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna