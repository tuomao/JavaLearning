package niuker;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-16.
 */
public class dulixiaoyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        int f=scanner.nextInt();
        int d=scanner.nextInt();
        int p=scanner.nextInt();
        System.out.println(new dulixiaoyi().maxLive(x,f,d,p));
    }

    public int maxLive(int x,int f,int d,int p){
        int result=0;
        if(d/f>=x){
            result +=f;
            d-= x*f;

            result+= d/(p+x);
        }else {
            result = d/x;
        }
        return result;
    }

}
