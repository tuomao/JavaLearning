package niuker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-16.
 */
public class DengchaShulie {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        int arr[]=new int[number];
        for(int i=0;i<number;i++){
            arr[i]=scanner.nextInt();
        }
        DengchaShulie dengchaShulie=new DengchaShulie();
        System.out.println(dengchaShulie.getResult(arr));
    }



    public String getResult(int[] arr){
        if(arr==null || arr.length<2) return "Impossible";
        qsort(arr,0,arr.length-1);
        int dis=arr[1]-arr[0];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]!=dis) return "Impossible";
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        return "Possible";

    }

    public void qsort(int[] arr,int left,int right){
        if(arr==null|| left>=right || right<0) return;

        int position=position(arr,left,right);
        if(left<position) qsort(arr,left,position-1);
        if(right>position) qsort(arr,position+1,right);
    }

    public int position(int[] arr,int left,int right){
        int d=arr[left];
        int i=left,j=right;
        while (i<j){
            while (i<j &&arr[j]>=d) j--;
            arr[i]=arr[j];
            while (i<j && arr[i]<=d) i++;
            arr[j]=arr[i];
        }
        arr[i]=d;
        return i;
    }
}
