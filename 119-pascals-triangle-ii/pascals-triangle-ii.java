class Solution {
    public List<Integer> getRow(int rowIndex) {
      //  List<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<=rowIndex;i++){
    //         int val=nCr(rowIndex,i);
    //         ans.add(val);
    //     }
    //     return ans;
    // }
    // public static int nCr(int r,int c){
    //     long result=1;
    //     for(int i=0;i<c;i++){
    //         result=result*(r-i);
    //         result=result/(i+1);
    //     }
    //     return (int) result;

    //APPROACH 2
    List<Integer> list=new ArrayList<>();
        if(rowIndex<0) return list;
        long ans=1;
        list.add(1);         //first and last always 1
        for(int i=1;i<=rowIndex;i++){
            ans=ans*(rowIndex-i+1);    //increase 
            ans/=i;                    //decrease
            list.add((int)ans);
        }
        return list;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna