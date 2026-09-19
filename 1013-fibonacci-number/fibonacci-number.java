import java.util.*;
class Solution {
    public int fib(int n) {
       
        int a=0;
        int b=1;
        for(int i=0;i<n;i++){
            System.out.println(a+" ");

            int c=a+b;
            a=b;
            b=c;
        }
        return a;
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