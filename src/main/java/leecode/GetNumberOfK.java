package leecode;

import org.junit.Test;

/**
 * Created by tuomao on 2017-06-16.
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0) return 0;
        int index=bfind(array,k);
        if(index==-1) return 0;
        int counter=1;
        int i=index;
        while (i>=1){
            if(array[i-1]==array[i]){
                counter++;
                i--;
            }
            else  break;
        }
        i=index;
        while (i<array.length-1){
            if(array[i+1]==array[i]){
                counter++;
                i++;
            }
            else break;
        }
        return counter;
    }

    public int bfind(int[] arr,int k){
        int l=0,r=arr.length-1;
        while (l<=r){
            int m=(l+r)/2;
            if(arr[m]==k) return m;
            else if(arr[m]<k) l=m+1;
            else if(arr[m]>k) r=m-1;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] arr={3,3,3,3,3,3,3,3,3};
        System.out.println(GetNumberOfK(arr,2));
        System.out.println(GetNumberOfK(arr,3));
    }
}
