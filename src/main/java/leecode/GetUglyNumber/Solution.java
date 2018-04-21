package leecode.GetUglyNumber;

import org.junit.Test;

/**
 * Created by tuomao on 2017-06-06.
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) throws Exception {
        if (index < 1) {
            return 0;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        for (int i = 1; i < index; i++) {
            arr[i] = getNextUglyNumber(arr, i);
        }
        return arr[index - 1];
    }

    /**
     * 用空间换取时间
     *
     * 下一个丑数：
     * min{当前的丑数*2 ,当前丑数*3,当前丑数*5}
     *
     * 事实上计算到下一个比最后一个丑数大的值的时候，即可返回结束了。
     *
     * @param arr
     * @param index
     * @return
     * @throws Exception
     */
    public int getNextUglyNumber(int[] arr, int index) throws Exception {
        if (index > arr.length - 1) throw new Exception("参数不合法");
        // 第index个是将要赋值的元素
        int curMax = arr[index - 1];

        int next2 = 2, next3 = 3, next5 = 5;
        boolean flag2=false,flag3=false,flag5=false;
        for (int i = 0; i < index; i++) {
            //  计算第一个比当前值大的即可
            if (next2 * arr[i] > curMax && !flag2){
                next2 = next2 * arr[i];
                flag2=true;
            }
            if (next3 * arr[i] > curMax && !flag3){
                next3 = next3 * arr[i];
                flag3=true;
            }
            if (next5 * arr[i] > curMax && !flag5) {
                next5 = next5 * arr[i];
                flag5=true;
            }

            // 所有都计算完，则返回
            if (flag2 && flag3 && flag5) break;
        }

        int min = next2;
        if (next3 < min) min = next3;
        if (next5 < min) min = next5;
        return min;
    }

    @Test
    public void testGetUglyNumber_Solution() throws Exception {
        System.out.println(GetUglyNumber_Solution(6));
        System.out.println(GetUglyNumber_Solution(7));
        System.out.println(GetUglyNumber_Solution(8));
        System.out.println(GetUglyNumber_Solution(9));
    }
}
