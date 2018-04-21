package niuker.VerifySquenceOfBST;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return VerifySquenceOfBSTHelper(sequence,0,sequence.length-1);
    }

    public boolean VerifySquenceOfBSTHelper(int[] sequence,int left,int right){
        if(right>left){
            int root=sequence[right];
            int index=left;

            // 找到第一个比root大的值，从那以后都是右子树
            while (index<=right-1){
                if(sequence[index]>root){
                    break;
                }
                index++;
            }

            for(int i=left;i<index;i++){
                if(sequence[i]>root){
                    return false;
                }
            }
            for (int i=index;i<right;i++){
                if(sequence[i]<root){
                    return false;
                }
            }
            // 验证左右子数是否满足该性质
            boolean result=true;
            if(left<index-1){
                result =result&&VerifySquenceOfBSTHelper(sequence,left,index-1);
            }
            if(index<right-1){
                result=result&&VerifySquenceOfBSTHelper(sequence,index,right-1);
            }
            return result;
        }else if(right==left) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] sequence = {1, 4, 3, 6, 9, 8, 5};
        System.out.println(new Solution().VerifySquenceOfBST(sequence));
    }
}
