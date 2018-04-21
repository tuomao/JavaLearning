package leecode.isContinuous;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    public boolean isContinuous(int[] numbers) {
        if(numbers!=null) {
            qsort(numbers, 0, numbers.length - 1);
            int zeroNumber = 0;
            int stepSum = 0;
            int i = 0;
            boolean firstNoneZero = false;
            while (i < numbers.length) {
                if (numbers[i] == 0) {
                    zeroNumber++;
                } else {
                    if (!firstNoneZero) {
                        firstNoneZero = true;
                    } else {
                        int step = numbers[i] - numbers[i - 1] - 1;
                        if (step < 0) {
                            return false;
                        }
                        stepSum += step;
                    }
                }
                i++;
            }
            if (zeroNumber >= stepSum) {
                return true;
            }
        }
        return false;
    }

    /**
     * 注意快排的写法
     * （1）
     * @param array
     * @param start
     * @param end
     */
    public void qsort(int[] array, int start, int end) {
        int left = start, right = end;
        if (array != null && left < right) {
            int m = array[left];
            while (left < right) {

                // 要先进行右部的循环，找到第一个比m小的数，放在left所在位置，由于left的值，保存下来了，所以可以这么做。
                while (array[right] >=m && right > left) {
                    right--;
                }
                array[left] = array[right];
                // 然后进行左部循环，找到第一个比m大的数，方法在right位置，因为right的数的值，已经移动到了left位置，所以可以这么搞
                // 注意要添加等号
                while (array[left] <= m && left < right) {
                    left++;
                }
                array[right]=array[left];
            }
            // 交换第一个数与left对应的数
            // 最后left所在位置的值是空闲的，把m放在这个位置上即可。
            array[left]=m;
            qsort(array, start, left - 1);
            qsort(array, left + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {0, 3, 0, 5, 6};
        System.out.println(new Solution().isContinuous(numbers));
    }
}
