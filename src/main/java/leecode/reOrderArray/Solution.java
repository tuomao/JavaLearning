package leecode.reOrderArray;

/**
 * Created by tuomao on 2017-03-03.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array={1,2,3,4,5,6};
        solution.reOrderArray_v1(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void reOrderArray(int[] array) {
        int[] tempArray = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                tempArray[j]=array[i];
                j++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                tempArray[j] = array[i];
                j++;
            }
        }
        for(int i=0;i<tempArray.length;i++){
            array[i]=tempArray[i];
        }
    }

    // 该算法会打乱顺序
    public void reOrderArray_v1(int [] array) {
        int i=0;
        while (i<array.length-1){
            if(array[i]%2==0){// 找打第一个偶数
                int j=i+1;
                while (j<array.length){// 找到后面的第一个奇数
                    if(array[j]%2!=0){
                        break;
                    }
                    j++;
                }

                // 注意：这里需要把从i到j-1所有的都往后移，
                // 不能简单的将i与j做交换，因为交换的话，会打乱数据之间的顺序
                if(j<array.length) {
                    // 将从i+1,到j的所有额数多往后移动一位
                    int temp=array[j];
                    for(int k=j;k>i;k--){
                        array[k]=array[k-1];
                    }
                    array[i]=temp;
                }else{
                    break;
                }
            }
            i++;
        }
    }

}
