package leecode.array;

/**
 * Created by tuomao on 2017-07-10.
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null|| length==0) return false;
        int[] arr=new int[length];
        for(int i=0;i<arr.length;i++) arr[i]=0;
        for(int i=0;i<length;i++) {
            arr[numbers[i]]+=1;
            if(arr[numbers[i]]>=2) {
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }
}
