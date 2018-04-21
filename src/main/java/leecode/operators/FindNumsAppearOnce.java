package leecode.operators;

/**
 * Created by tuomao on 2017-06-16.
 */

import org.junit.Test;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811
 * 来源：牛客网
 * <p>
 * 此题考察的是异或运算的特点：即两个相同的数异或结果为0。
 * 此题用了两次异或运算特点：
 * （1）第一次使用异或运算，得到了两个只出现一次的数相异或的结果。
 * <p>
 * （2）因为两个只出现一次的数肯定不同，即他们的异或结果一定不为0，一定有一个位上有1。
 * 另外一个此位上没有1，我们可以根据此位上是否有1，将整个数组重新划分成两部分，一部分此位上一定有1，
 * 另一部分此位上一定没有1，然后分别对每部分求异或，因为划分后的两部分有这样的特点：
 * 其他数都出现两次，只有一个数只出现一次。因此，我们又可以运用异或运算，分别得到两部分只出现一次的数。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int sum = 0;

        // 异或的特点  相同为0，不同为1
        // sumz最后的值是,A^B的值
        // A^B的值的取值  不为1的地方，那么就是A和B对应的位不同
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }

        // 找到第一个A和B对应位不同的地方
        int index;
        for (index = 1; index < 32; index++) {
            if ((sum & (1 << index)) != 0) break;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & (1 << index)) != 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }


    /**
     *      * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     *      * @param a
     *      * @return
     *      
     */
    public static int find1From2(int[] a) {
        int len = a.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    public static int find1FromN(int[] arr, int n) {
        int a = 0;
        for (int j = 0; j < 32; j++) {

            // 求解出每一个位上出现的1的次数
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] & (1 << j);
            }

            // 对于出现n的数字来说，该位上出了单独的那个数字以外，都能被n整除
            // 如果不能被n整除，那么该数字的该位的值就只1，通过异或就可以计算出来
            if (sum % n != 0) a |= (1 << j);
        }

        return a;
    }

    @Test
    public void testfind1FromN() {
        int[] array = {1, 2, 2, 3, 3};
        int[] array1 = {1, 2, 2, 2, 3, 3, 3};
        System.out.println(find1FromN(array, 2));
        System.out.println(find1FromN(array1, 3));
    }

    /**
     *      * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     *      * @param a
     *      * @return
     *      
     */

    public static int find1From3(int[] a) {
        int[] bits = new int[32];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((a[i] >>> j) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }
}
