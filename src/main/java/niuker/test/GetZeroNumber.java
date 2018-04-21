package niuker.test;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-22.
 */
public class GetZeroNumber {

    public static void main(String[] args){
        Scanner scanner=new Scanner((System.in));
        int n=scanner.nextInt();

        System.out.println(getNumber(n));
    }

    public static int getNumber(int n){
       if (n>0) return getNumber(n/5)+n/5;
       else return 0;
    }
}
