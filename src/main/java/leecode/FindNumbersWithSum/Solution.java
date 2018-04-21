package leecode.FindNumbersWithSum;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>(2);
        int left = 0, right = array.length - 1;
        while (left < right) {
            int sub = sum - array[left];
            int index = binarySearch(array, sub, left + 1, right);

            if (index != -1) {
                list.add(array[left]);
                list.add(sub);
                break;
            }
            left++;

        }

        return list;
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum){
        ArrayList<Integer> list = new ArrayList<>(2);
        int left=0,right=array.length-1;
        while (left<right){
            int sub=sum-array[left];
            if(sub>array[right]){
                left++;
            }else if(sub<array[right]){
                right--;
            }else{
                list.add(array[left]);
                list.add(sub);
                break;
            }
        }
        return list;
    }

    /**
     *
     * 思路：
     * （1）性质：两个数的和为一个数，要乘积最小，那么这两个数的差值越大越好
     * （2）根据性质1，我们可以想到，从两头分别开始找，一直找到两个数和为sum即可。
     * @param array
     * @param num
     * @param left
     * @param right
     * @return
     */
    public int binarySearch(int[] array, int num, int left, int right) {

        int index = -1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (array[m] > num) {
                right = m - 1;

            } else if (array[m] < num) {
                left = m + 1;
            } else if (array[m] == num) {
                index = m;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 8, 14, 15};
        int sum = 16;
        System.out.println(new Solution().FindNumbersWithSum(array,16));
    }
}
