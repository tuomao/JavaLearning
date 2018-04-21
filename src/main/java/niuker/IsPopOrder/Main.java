package niuker.IsPopOrder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        POT[] points = new POT[n];
        boolean[] potflag = new boolean[n];
        for (int i = 0; i < n; i++) {
            POT pot = new POT();
            pot.x = s.nextInt();
            pot.y = s.nextInt();
            points[i] = pot;
            potflag[i] = false;
        }
        Arrays.sort(points, new Comparator<POT>() {
            public int compare(POT arr1, POT arr2) {
                if (arr1.x == arr2.x)
                    return arr1.y - arr2.y;
                else
                    return arr1.x - arr2.y;
            }
        });
        potflag[n - 1] = true;
        int flag = points[n - 1].y;
        for (int i = n - 2; i >= 0; i--) {
            if (points[i].y > flag) {
                potflag[i] = true;
                flag = points[i].y;
            }
        }
        for (int i = 0; i < n; i++)
            if (potflag[i])
                System.out.println(points[i].x + " " + points[i].y);
    }

    static class POT {
        int x;
        int y;
    }

    public int getMax(int[] arr){



        if(arr==null || arr.length==0) return 0;
        int[] sum=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(i==0) sum[i]=arr[i];
            else sum[i]=sum[i-1]+arr[i];
        }
        int min[]=new int[arr.length];

        int result=-1;
        for(int i=0;i<arr.length;i++){
            min[i]=arr[i];
            for(int j=i;j<arr.length;j++){
                if(j>i) {
                    min[j] = Math.min(min[j - 1], arr[j]);
                }
                int tempSum;
                if(i>0) tempSum=sum[j]-sum[i-1];
                else tempSum=sum[j];
                int temp=min[j] *tempSum;
                if(temp>result) result=temp;
            }
        }
        return result;
    }


}
