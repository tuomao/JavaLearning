package leecode.find;

import org.junit.Test;

/**
 * Created by tuomao on 2017-06-16.
 */
public class minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0) return 0;



        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]) return array[i+1];
        }

        return array[0];

    }

    @Test
    public  void test(){
        int[] arr={1,1,1,1,1};
        int[] arr1={1};
        int[] arr2={2,2,3,4,1};
        System.out.println(minNumberInRotateArray(arr));
        System.out.println(minNumberInRotateArray(arr1));
        System.out.println(minNumberInRotateArray(arr2));
    }
}
