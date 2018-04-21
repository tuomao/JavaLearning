package leecode.topk;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-06-05.
 */
public class HeapSort {

    public static void adjustBigHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        int i = 2 * start + 1;
        while (i <= end) {
            if (i + 1 <= end && arr[i + 1] > arr[i]) i++;
            if (arr[i] < temp) break;
            arr[start] = arr[i];
            arr[i] = temp;
            start = i;
            i = 2 * start + 1;
        }
    }

    public static void adjustSmallHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        int i = 2 * start + 1;
        while (i <= end) {
            if (i + 1 <= end && arr[i + 1] < arr[i]) i++;
            if (temp < arr[i]) break;
            arr[start] = arr[i];
            arr[i] = temp;
            start = i;
            i = 2 * start + 1;
        }
    }


    public static void buildBigHeap(int[] arr, int end) {
        for (int i = (end - 1) / 2; i >= 0; i--) adjustBigHeap(arr, i, end);
    }

    public static void buildSmallHeap(int[] arr, int end) {
        for (int i = (end - 1) / 2; i >= 0; i--) adjustSmallHeap(arr, i, end);
    }

    public static void heapSort(int[] arry) {
        buildBigHeap(arry, arry.length - 1);
        for (int i = arry.length - 1; i > 0; i--) {
            int temp = arry[i];
            arry[i] = arry[0];
            arry[0] = temp;
            adjustBigHeap(arry, 0, i - 1);
        }
    }

    @Test
    public void testHeapSort() {
        int array[] = {2, 2, 3, 7, 5, -1, 0, 4, 4, 4,};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> kBig(int[] array, int k) {


        ArrayList<Integer> result = new ArrayList<>();

        if (k <= array.length) {

            buildSmallHeap(array, k - 1);


            for (int i = k; i < array.length; i++) {
                if (array[i] > array[0]) {
                    int temp = array[0];
                    array[0] = array[i];
                    array[i] = temp;
                    adjustSmallHeap(array, 0, k - 1);
                }
            }
            for (int i = 0; i < k; i++) {
                result.add(array[i]);
            }
        }
        return result;
    }


    @Test
    public void testKbig() {
        int array[] = {4, 5, 1, 6, 2, 7, 3, 8};

        System.out.println(kBig(array, 2));
        System.out.println(kBig(array, 3));
        System.out.println(kBig(array, 4));
        System.out.println(kBig(array, 5));
    }

    @Test
    public void testkSmall() {
        int array[] = {4, 5, 1, 6, 2, 7, 3, 8};

        System.out.println(kSmall(array, 4));
    }

    public static ArrayList<Integer> kSmall(int[] array, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (k <= array.length) {
            buildBigHeap(array, k - 1);
            for (int i = k; i < array.length; i++) {
                if (array[i] < array[0]) {
                    int temp = array[0];
                    array[0] = array[i];
                    array[i] = temp;
                    adjustBigHeap(array, 0, k - 1);
                }
            }
            for (int i = 0; i < k; i++) {
                result.add(array[i]);
            }
        }
        return result;
    }
}
