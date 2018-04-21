package leecode;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-03-31.
 */
public class Main {


    private int P;
    private int Q;
    private int N;

    public Main(int P, int Q, int N) {
        this.P = P;
        this.Q = Q;
        this.N = N;
    }


    public double compute(int p, int n, int step, double pro) {
        if (n == 0) {
            System.out.println(pro + " " + step);
            return pro * step;
        }
        double l=0;
        if (p >0) {
            double lp = pro * p / 100;
            ++step;
            l = compute((int) ((P / Math.pow(2, N - n + 1))), n - 1, step, lp);
        }
        if (p < 100) {
            double rp = pro * (1 - (double)p / 100);
            int min = Math.min(p + Q, 100);
            l += compute(min, n, step, rp);
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();
            int n= in.nextInt();
            try {
                Main items = new Main(p, q, n);
                double result=items.compute(p,n,0,1);
                System.out.println(result);
            }catch (Exception e){

            }

//            System.out.println(String.format("%.2f",result));
        }
    }
}
