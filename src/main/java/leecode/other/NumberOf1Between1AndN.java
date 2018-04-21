package leecode.other;

import org.junit.Test;

/**
 * Created by tuomao on 2017-08-24.
 */
public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {
        return getNumber(n,1);
    }

    public int getNumber(int n,int x){
        if(n<=0 || x<=0 || x>9) return 0;
        int high,low,cur,temp;
        int sum=0;
        high=n;
        int base=1;
        while(high!=0){
            high=n/ (base*10);
            temp=n% (base*10);
            cur= temp / base;
            low= temp% base;

            if(cur>x) sum+= (high+1) * base;
            else if(cur==x) sum=sum+ high * base +low+1;
            else sum+= high* base;
            base*=10;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(new NumberOf1Between1AndN().getNumber(1,1));
    }
}
