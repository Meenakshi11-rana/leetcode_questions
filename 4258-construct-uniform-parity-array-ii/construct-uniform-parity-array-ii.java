class Solution {
    public boolean uniformArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int x : nums) {
            min = Math.min(min, x);

            if (x % 2 != 0) {
                minOdd = Math.min(minOdd, x);
            }
        }

        for (int x : nums) {
            if (x % 2 != min % 2) {
                if (x <= minOdd) {
                    return false;
                }
            }
        }

        return true;
    }
}