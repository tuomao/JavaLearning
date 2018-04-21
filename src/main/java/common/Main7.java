package common;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-25.
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        while (t > 0) {
            n = scanner.nextInt();
            System.out.println(work(n));
        }
    }

    public static String work(int n) {
        String string = String.valueOf(n);
        int[] flag = new int[string.length()];
        for (int i = 0; i < flag.length; i++) flag[i] = 0;
        boolean result = mWork(string, flag, new StringBuffer());
        if (result) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    public static boolean mWork(String src, int[] flags, StringBuffer dest) {
        if (src.length() == dest.toString().length()) {
            int srcInt = Integer.valueOf(src);
            int destInt = Integer.valueOf(dest.toString());
            if (destInt > srcInt && destInt % srcInt == 0) return true;
        } else {
            for (int i = 0; i < src.length(); i++) {
                if (flags[i] == 0) {
                    flags[i] = 1;
                    dest.append(src.charAt(i));
                    boolean result = mWork(src, flags, dest);
                    flags[i] = 0;
                    dest.deleteCharAt(dest.length() - 1);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
