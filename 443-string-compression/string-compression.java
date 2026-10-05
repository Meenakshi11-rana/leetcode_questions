class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        ///take a index variable to store result on that index
        int index=0;
        int i=0;
        while(i<n){
            //take current char and count =0
            char curr_char=chars[i];
            int count=0;

            //count how many occurance of same character
            while(i<n && chars[i]==curr_char){
                count++;
                i++;
            }

            //assign the current char and increase the index
            chars[index]=curr_char;
            index++;

            //if our count is greater than 1 then
            if(count>1){
                //convert the count into string
                String s=Integer.toString(count);

                //store every charr in a single elements of the chars
                for(char ch:s.toCharArray()){
                    chars[index++]=ch;
                }
            }
        }
        //return length of index
        return index;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna