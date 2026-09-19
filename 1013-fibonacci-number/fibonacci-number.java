import java.util.*;
class Solution {
    public int fib(int n) {
       
       if(n<2){
        return n;
       }
        int a=0;
        int b=1;
        int c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
        //return fibo(n);
    //}        
    // public static int fibo(int n){
    //     if(n==0||n==1){
    //         return n;
    //     }
    //     else{
    //         return fibo(n-1)+fibo(n-2);
    //     }
    }
}