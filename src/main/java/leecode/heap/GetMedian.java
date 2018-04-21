package leecode.heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by tuomao on 2017-07-13.
 */

/**
 * 1. 数据分成两段  大顶堆| 小顶堆
 * 2. 奇数的时候插入大顶堆，偶数插入小顶堆
 * 3. 如果插入大顶堆，那么当前的值应该比小顶堆的堆顶值小，如果比它大，则与小顶堆的值交换。同理插入大顶堆
 *
 */

public class GetMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    Queue<Integer> minHeap = new PriorityQueue<>();

    int length = 0;

    public void Insert(Integer num) {
        length++;
        if ((length & 1) == 0) {// 偶数
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else { // 奇数
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if ((length & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }

    @Test
    public void test(){
        int[] a={5,2,3,4,1,6,7,0,8};
        for(int i=0;i<a.length;i++){
            Insert(a[i]);
            System.out.println(GetMedian());
        }
    }
}
