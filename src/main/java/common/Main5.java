package common;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-09-24.
 */
public class Main5 {
    public static int minstep = -1;
    public static char[][] mat;
    public static int m;
    public static int n;
    public static int l;
    public static int r;
    public static int t;
    public static int d;
    public static int k;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        m = Integer.valueOf(strings[0]);
        n = Integer.valueOf(strings[1]);
        mat = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            mat[i] = s.toCharArray();
        }
        k = scanner.nextInt();
        System.out.println(getMinStep());
    }

    public static int getMinStep() {
        set();
        char[] ops = {'t', 'l'};
        work(0, ops);
        set();
        char[] ops1 = {'l', 'd'};
        work(0, ops1);
        set();
        char[] ops2 = {'r', 't'};
        work(0, ops2);
        set();
        char[] ops3 = {'r', 'd'};
        work(0, ops3);
        return minstep;
    }

    public static void set() {
        l = 0;
        r = n - 1;
        t = 0;
        d = m - 1;
    }

    public static void work(int step, char[] ops) {
        if (minstep != -1 && step >= minstep) return;
        int cur = getCur();
        if (cur == k) {
            setStep(step);
            return;
        } else if (cur < k) {
            return;
        } else {
            for (char op : ops) {
                move(op);
                work(step + 1, ops);
                reverseMove(op);
            }
        }
    }


    public static void setStep(int step) {
        if (minstep == -1) {
            minstep = step;
        } else if (step < minstep) {
            minstep = step;
        }
    }

    public static void move(char d) {
        switch (d) {
            case 't':
                t++;
                break;
            case 'd':
                d--;
                break;
            case 'l':
                l++;
                break;
            case 'r':
                r--;
                break;
        }
    }

    public static void reverseMove(char d) {
        switch (d) {
            case 't':
                t--;
                break;
            case 'd':
                d++;
                break;
            case 'l':
                l--;
                break;
            case 'r':
                r++;
                break;
        }
    }

    public static int getCur() {
        int c = 0;
        if (l < 0 || l > r || r > n - 1 || t < 0 || t > d || d > m - 1) {
            return 0;
        }
        for (int i = t; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (mat[i][j] == 'o') c++;
            }
        }
        return c;
    }
}
