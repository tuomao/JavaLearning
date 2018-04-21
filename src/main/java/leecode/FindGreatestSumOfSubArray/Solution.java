package leecode.FindGreatestSumOfSubArray;

/**
 * Created by tuomao on 2017-06-05.
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) throws Exception {
        if(array==null|| array.length==0){
            throw  new Exception("参数不合法");
        }
        int c=array[0],max=array[0];
        for(int i=1;i<array.length;i++){
            if(c<0) c=array[i];
            else c+=array[i];
            if(c>max) max=c;
        }
        return max;
    }


}
