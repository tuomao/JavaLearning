package leecode.Power;

/**
 * Created by tuomao on 2017-03-03.
 */
public class Solution {

    public static void main(String[] args){
        Solution solution=new Solution();
        double result=solution.Power(2,-3);
        System.out.println(result);
    }

    public double Power(double base, int exponent) {
        double result=1;
        int flag=1;// 0负数 1整数
        if(exponent<0) {
            exponent=0-exponent;
            flag=0;
        }
        while (exponent > 0) {
            result *= base;
            exponent--;
        }

        if(flag==0){
            result=1/result;
        }

        return  result;
    }
}
