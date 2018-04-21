package niuker.test;

import java.util.*;

/**
 * Created by tuomao on 2017-08-22.
 */
public class PlanNumber {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int sum=scanner.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++) arr[i]=scanner.nextInt();
        System.out.println( planNumber(arr,n, sum));
    }

    public static int  planNumber(int[] arr,int n,int sum){
        int[][] m=new int[n+1][sum+1];

        for(int i=1;i<=n;i++) m[i][0]=1;

        for(int i=1;i<=sum;i++) m[0][i]=0;

        m[0][0]=1;

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(j>=arr[i]) m[i][j]=m[i-1][j]+m[i-1][j-arr[i]];
                else m[i][j]=m[i-1][j];
            }
        }

        return m[arr.length-1][sum];
    }

}
