import java.util.*;
class Solution {
    public int fib(int n) {
        Scanner sc=new Scanner(System.in);
        
        int a=0;
        int b=1;
        for(int i=0;i<n;i++){
            System.out.println(a+" ");

            int c=a+b;
            a=b;
            b=c;
        }
        return a;
    }        
}