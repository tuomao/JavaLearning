package leecode.NumberOf1;

/**
 * Created by tuomao on 2017-03-03.
 */
public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        int result=solution.NumberOf1(3);
        System.out.println(result);
    }

    public int NumberOf1_v2(int n) {
        String string=Integer.toBinaryString(n);
        int counter=0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='1'){
                counter++;
            }
        }
        return  counter;
    }

    public int NumberOf1(int n) {
        int counter=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0){
                counter++;
            }
            flag=flag<<1;
        }
        return  counter;
    }
}
