package niuker;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-16.
 */
public class OperateSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int arr[] = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }
        OperateSequence dengchaShulie = new OperateSequence();
        System.out.println(dengchaShulie.getSequence(arr));
    }

    public String getSequence(int[] arr) {
        if (arr == null || arr.length == 0) return "";

        if (arr.length == 1) return String.valueOf(arr[0]);

        Integer[] b = new Integer[arr.length];
        int index = 0;
        int  i = arr.length - 1;

        while (i >= 0) {
            b[index] = arr[i];
            i -= 2;
            index++;
        }


        if(arr.length %2==0) i=0;
        else i=1;


        while (i < arr.length) {
            b[index] = arr[i];
            i += 2;
            index++;
        }
        StringBuffer buffer=new StringBuffer();
        int k=0;
        for(k=0;k<arr.length-1;k++){
            buffer.append(b[k].toString()+" ");
        }
        buffer.append(b[k]);
        return buffer.toString();
    }
}
