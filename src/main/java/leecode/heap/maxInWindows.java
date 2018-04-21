package leecode.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tuomao on 2017-07-13.
 */
public class maxInWindows {


    public ArrayList<Integer> maxInWindows1(int[] num, int size) {

        ArrayList<Integer> results = new ArrayList<>();
        if (num == null) return results;

        int i = 0;
        Integer max = null;
        while (i < size && i < num.length) {
            if (max == null) max = num[i];
            else if (max < num[i]) max = num[i];
            i++;
        }
        results.add(max);
        while (i < num.length) {
            if (num[i - size] == max) {
                max = num[i];
                for (int j = i - size + 1; j < i; j++) {
                    if (num[j] > max) max = num[j];
                }
            } else {
                max = Math.max(max, num[i]);
            }
            results.add(max);
            i++;
        }

        return results;
    }

    /**
     * 1. 用双向队列保存，队列的头部保存当前窗口的最大值的索引
     * 2. 如果头部的最大值过期  i-size>=quque.getFirst(),那么就直接丢弃掉
     * 3. 从队列的尾部开始遍历，一直到将所有比它小的值都丢弃掉，然后将当前值保存到对尾（因为，以前的所有比他小的值，都不可能成为备选的最大值）
     * 4. 当前的队列一定一个递减的队列（很简单，因为3步的操作会将所有比它小的值都丢弃掉，因此，当头部过期的时候，第二大的值，自然成了候选的最大值）
     * 5. 队里保存的是下标，只有保存下标才能知道其是否过期了
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> results = new ArrayList<>();
        if (num == null || size==0) return results;
        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0;
        while (i < num.length) {
            while (!queue.isEmpty() && i - size >= 0 && queue.getFirst() <= i - size) queue.removeFirst();
            while (!queue.isEmpty() && num[i] > num[queue.getLast()]) queue.removeLast();
            queue.addLast(i);
            if(i>=size-1) {
                results.add(num[queue.getFirst()]);
            }
            i++;
        }

        return results;
    }


    @Test
    public void test() {
        int[] a = {16, 14, 12, 10, 8, 6, 4};
        System.out.println(maxInWindows(a, 5));
    }

}
