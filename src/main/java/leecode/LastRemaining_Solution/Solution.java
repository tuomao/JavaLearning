package leecode.LastRemaining_Solution;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        boolean[] flags = new boolean[n];
        for(int i=0;i<flags.length;i++){
            flags[i]=false;
        }
        int length = n;
        int index = -1;
        while (length > 0) {
            int temp=m;
            while (temp>0){
                index=(index+1)%n;
                if(!flags[index]){
                    temp--;
                }
            }
            // 去除掉当前选中的孩子
            System.out.println("选中："+index);
            flags[index]=true;
            length--;
        }
        return index;
    }

    public static void main(String[] args){
        System.out.println(new Solution().LastRemaining_Solution(7,3));
    }
}
