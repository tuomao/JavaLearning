package leecode.PrintMinNumber;

import org.junit.Test;

/**
 * Created by tuomao on 2017-06-05.
 */
public class Solution {

    /**
     * 1. 将数组转化为字符串
     * 2. 利用快排对字符串进行排序（主要是自己定义好排序的规则）
     * 3. 直接输出排序后的字符串
     * @param numbers
     * @return
     * @throws Exception
     */
    public String PrintMinNumber(int[] numbers) throws Exception {
        String[] strings = new String[numbers.length];
        // 转化为string
        for (int i = 0; i < strings.length; i++) strings[i] = String.valueOf(numbers[i]);
        // 对string进行排序
        qsort(strings,0,strings.length-1);
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<strings.length;i++){
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }

    public int partition(String[] strings, int start, int end) throws Exception {
        if (strings == null || end < start || start < 0) {
            throw new Exception("参数不合法");
        }
        String pivot = strings[start];
        while (start < end) {
            while (start < end && compare(strings[end], pivot) >= 0) end--;
            strings[start] = strings[end];
            while (start < end && compare(strings[start], pivot) <= 0) start++;
            strings[end] = strings[start];
        }
        strings[start] = pivot;
        return start;
    }

    public void qsort(String[] strings, int start, int end) throws Exception {
        if (strings == null || start < 0 || end < start || end > strings.length - 1) throw new Exception("参数不合法");
        if (end > start) {
            int partition = partition(strings, start, end);
            if (partition > start) qsort(strings, start, partition - 1);
            if (partition < end) qsort(strings, partition + 1, end);
        }
    }

    /**
     * 排序的规则
     *
     * 如果a的长度大于b的长度，那么就循环的用b与a比较，直达到达a的最后一位
     * 同理b的长度大于a的长度
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(String a, String b) {
        int i=0 ,j=0;
        if(a.length()<=b.length()){
            while (j<b.length()){
                if (a.charAt(i) == b.charAt(j)){
                    i++;
                    if(i==a.length()) i=0;
                    j++;
                }
                else if (a.charAt(i) < b.charAt(j)) return -1;// 小于
                else return 1;// 大于
            }
        }else{
            while (i<a.length()){
                if (a.charAt(i) == b.charAt(j)){
                    i++;
                    j++;
                    if(j==b.length()) j=0;
                }
                else if (a.charAt(i) < b.charAt(j)) return -1;// 小于
                else return 1;// 大于
            }
        }
        return 0;
    }


    @Test
    public void testcompare(){
        System.out.println(compare("321", "3"));
        System.out.println(compare("34","3"));
        System.out.println(compare("33","3"));
    }


    @Test
    public void testPrintMinNumber() throws Exception {
        int numbers[]={3,32,321};
        System.out.println(PrintMinNumber(numbers));
        int numbers1[]={3334,3,3333332};
        System.out.println(PrintMinNumber(numbers1));
    }
}
