package niuker.IsPopOrder;

import java.util.Stack;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    /**
     *
     * @param pushA
     * @param popA
     * @return
     *
     * 解题思路，模拟栈的操作即可
     *
     * 注意：此题的条件是，假设栈里面的每一个元素都不相同
     * 1. 遍历出栈的每一个元素
     * 2. 该元素只能出现在两个位置 （1）栈顶  （2）从index（index表示到index为止pushA的元素都已经消费了）到pushA尾部这一段中的其中一个元素
     * 3. 情况1：则把栈顶元素出栈即可
     * 4. 情况2：把从index为止，到查找到的对应元素位置j的所有元素都入栈，同时把index指向j+1。
     *
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        boolean flag;
        for(int i=0;i<popA.length;i++){
            flag=false;
            if(!stack.empty()){
                if(stack.peek()==popA[i]){
                    stack.pop();
                    continue;
                }
            }

            for(int j=index;j<pushA.length;j++){
                if(pushA[j]==popA[i]){
                    for(int k=index;k<j;k++){
                        stack.push(pushA[k]);
                    }
                    index=j+1;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        System.out.println(new Solution().IsPopOrder(pushA,popA));
    }

}