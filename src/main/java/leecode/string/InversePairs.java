package leecode.string;

import org.junit.Test;

/**
 * Created by tuomao on 2017-07-09.
 */

/**
 * 1. 采用归并排序的思想
 * 2. 在合并的时候，从右边开始合并，如果左边大于右边，那么，则出现逆序对的个数为 j-i
 * 3. 最后总的逆序对个数为   左边+右边+自己合并出现的逆序对总数
 * 
 */
public class InversePairs {

    public int InversePairs_complex(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j])
                    counter = (counter + 1) % 1000000007;
            }
        }
        return counter;
    }

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        int counter=mergeSort(array, copy, 0, array.length - 1);
//        for(int i=0;i<array.length;i++){
//            System.out.print(array[i]+",");
//        }
//        System.out.println();
        return counter;
    }

    public int mergeSort(int[] array, int[] copy, int l, int r) {

        if (l == r) {
            return 0;
        }

        int m = (l + r) >> 1;

        int counter = 0;
        counter = (counter + mergeSort(array, copy, l, m)) % 1000000007;
        counter = (counter + mergeSort(array, copy, m + 1, r)) % 1000000007;
        int i = m, j = r, index = r;
        while (i >= l && j > m) {
            if (array[i] > array[j]) {
                counter= (counter+(j - m )) %1000000007;
                copy[index--] = array[i--];
            } else {
                copy[index--] = array[j--];
            }
        }
        while (i >= l) copy[index--] = array[i--];
        while (j > m) copy[index--] = array[j--];
        for (i = l; i <= r; i++) array[i] = copy[i];
        return counter;
    }

    @Test
    public void testInversePairs() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }
}
