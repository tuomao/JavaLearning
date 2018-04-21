package common;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-25.
 */
public class Main8 {
    static BigInteger[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        System.out.println(work(n, x));
    }

    public static String work(int n, int x) {
        arr = new BigInteger[n + 1][x + 1];
        for (int i = 0; i <= n; i++) arr[i][0] = pow(6, i);
        for (int i = 1; i <= x; i++) arr[0][i] = new BigInteger("0");
        BigInteger s = new BigInteger("0");
        int t = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                s = new BigInteger("0");
                for (int k = 1; k <= 6; k++) {
                    t = j - k;
                    if (t < 0) t = 0;
                    s = s.add(arr[i - 1][t]);
                }
                arr[i][j] = s;
            }
        }
      
        String result = "";
        BigInteger fra = pow(6, n);
        if (arr[n][x].equals(new BigInteger("0"))) {
            result = "0";
        } else if (arr[n][x].equals(fra)) {
            result = "1";
        } else {
            BigInteger maxD = fra.gcd(arr[n][x]);
            result = arr[n][x].divide(maxD) + "/" + fra.divide(maxD);
        }
        return result;
    }


    public static BigInteger pow(int b, int n) {
        BigInteger r = new BigInteger("1");
        BigInteger b1 = new BigInteger(String.valueOf(b));
        for (int i = 0; i < n; i++) r = r.multiply(b1);
        return r;
    }


}
