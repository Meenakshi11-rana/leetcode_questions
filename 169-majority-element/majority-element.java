class Solution {
    public int majorityElement(int[] nums) {
        int ele =0;
        int count=0;
        for(int val:nums){
            if(count==0){
                ele=val;
            }
            if(ele==val){

                count++;
            }else{
                count--;
            }
        }
        return ele;
    }
}