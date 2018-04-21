package leecode.topk;

import org.junit.Test;

/**
 * Created by tuomao on 2017-06-05.
 */
public class QuickSort {

    public static void qsort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);
            if (pivot > start) qsort(a, start, pivot - 1);
            if (pivot < end) qsort(a, pivot + 1, end);
        }
    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot) end--;
            a[start] = a[end];
            while (start < end && a[start] <= pivot) start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }

    @Test
    public void testQsort() {
        int array[] = {2, 2, 3, 7, 5, -1, 0, 4, 4, 4,};
        qsort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int kSmallNumber(int[] array, int start, int end, int k) throws Exception {
        if (end - start + 1 >= k && start >= 0 && k > 0) {
            int pivot = partition(array, start, end);
            if (pivot - start + 1 == k) return array[pivot];
            if (pivot - start + 1 > k) return kSmallNumber(array, start, pivot - 1, k);
            return kSmallNumber(array, pivot + 1, end, k - (pivot - start + 1));
        } else {
            throw new Exception("参数不合法");
        }
    }

    public static int kBigNumber(int[] array, int start, int end, int k) throws Exception {
        if (end - start + 1 >= k && start >= 0 && k > 0) {
            int pivot = partition(array, start, end);
            if (end - pivot + 1 == k) return array[pivot];
            if (end - pivot + 1 > k) return kBigNumber(array, pivot + 1, end, k);
            return kBigNumber(array, start, pivot - 1, k - (end - pivot + 1));
        } else {
            throw new Exception("参数不合法");
        }
    }

    public static int topK(int[] array, int start, int end, int k) throws Exception {
        if (end - start + 1 >= k && start >= 0 && k > 0) {
            int pivot = partition(array, start, end);
            if (end - pivot + 1 == k) return pivot;
            if (end - pivot + 1 > k) return topK(array, pivot + 1, end, k);
            return topK(array, start, pivot - 1, k - (end - pivot + 1));
        } else {
            throw new Exception("参数不合法");
        }
    }



    @Test
    public void testkSmallNumber() {
        int array[] = {2, 2, 3, 7, 5, -1, 0, 4, 4, 4,};

        try {
            System.out.println(kSmallNumber(array, 0, array.length - 1, 3));
            System.out.println(kSmallNumber(array, 0, array.length - 1, 4));
            System.out.println(kSmallNumber(array, 0, array.length - 1, 7));
            System.out.println(kSmallNumber(array, 0, array.length - 1, 9));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testkBigNumber() {
        int array[] = {2, 2, 3, 7, 5, -1, 0, 4, 4, 4,};
        try {
            System.out.println(kBigNumber(array, 0, array.length - 1, 1));
            System.out.println(kBigNumber(array, 0, array.length - 1, 3));
            System.out.println(kBigNumber(array, 0, array.length - 1, 4));
            System.out.println(kBigNumber(array, 0, array.length - 1, 7));
            System.out.println(kBigNumber(array, 0, array.length - 1, 9));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testTopK() {
        int array[] = {2, 2, 3, 7, 5, -1, 0, 4, 4, 4,};
        try {
            for (int i = topK(array, 0, array.length - 1, 1); i < array.length; i++) System.out.println(array[i] + " ");
            System.out.println();
            for (int i = topK(array, 0, array.length - 1, 3); i < array.length; i++) System.out.println(array[i] + " ");
            System.out.println();
            for (int i = topK(array, 0, array.length - 1, 5); i < array.length; i++) System.out.println(array[i] + " ");
            System.out.println();
            for (int i = topK(array, 0, array.length - 1, 6); i < array.length; i++) System.out.println(array[i] + " ");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
