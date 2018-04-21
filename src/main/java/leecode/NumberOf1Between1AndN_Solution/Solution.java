package leecode.NumberOf1Between1AndN_Solution;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-06-05.
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1){
            return 0;
        }
        ArrayList<Integer> array=numberToArray(n);
        int sum=0;
        for(int i=0;i<array.size();i++){
            int temp=1;
            for(int j=0;j<array.size();j++){
                if(j!=i){
                                                   if(j<i) temp*=9;
                    else if(j==array.size()-1) temp=temp*(array.get(j)+1);
                    else j*=10;
                }
            }
            sum+=temp;
        }
        return sum;

    }
    @Test
    public void testNumberOf1Between1AndN_Solution(){
        System.out.println(NumberOf1Between1AndN_Solution(55));
    }

    public ArrayList<Integer> numberToArray(int n){
        ArrayList<Integer> array=new ArrayList<>();
        while (n!=0){
            array.add(n%10);
            n=n/10;
        }
        return array;
    }
}
