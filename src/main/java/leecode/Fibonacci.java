package leecode;

/**
 * Created by tuomao on 2017-06-16.
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int a=1,b=2,c=0;
        for(int i=0;i<n-2;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }


}
