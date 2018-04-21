package common;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-23.
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        int n = scanner.nextInt();
        String result = (pow(r, n));
        String t = String.valueOf(r);
        int index = t.indexOf('.');
        int pn = 0;
        if (index > 0) {
            pn = (t.length() - 1 - index) * n;
        }

        if (pn == 0) {
            System.out.println(result);
        } else {
            index = result.indexOf('.');
            String s = result.substring(0, index + 1) + result.substring
                    (index + 1, index + 1 + pn);
            System.out.println(s);
        }

    }

    static String pow(double d, int n) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal num1 = new BigDecimal(d);
        for (int i = 0; i < n; i++) {
            result = result.multiply(num1);
        }
        return result.toString();
    }
}
