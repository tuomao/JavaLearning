package garbageCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-22.
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=s.nextInt();
        System.out.println(new Main().getMax1(arr));
    }


    public int getMax1(int[] arr){

        if(arr==null || arr.length==0) return 0;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                ArrayList<Integer> list=map.get(arr[i]);
                list.add(i);
            }else {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
        }

        int[] sum=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(i==0) sum[i]=arr[i];
            else sum[i]=sum[i-1]+arr[i];
        }
        int result=-1;
        for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            int key=entry.getKey();
            ArrayList<Integer> value=entry.getValue();
            int max=-1;
            for(int i=0;i<value.size();i++){
                if(value.get(i)>max) max=value.get(i);
            }
            int temp=key * sum[max];
            if(temp> result) result=temp;
        }
        return result;
    }
}
