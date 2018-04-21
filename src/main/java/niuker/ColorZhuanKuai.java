package niuker;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-16.
 */
public class ColorZhuanKuai {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();

        ColorZhuanKuai colorZhuanKuai=new ColorZhuanKuai();
        System.out.println(colorZhuanKuai.getNumber(string));
    }

    public int getNumber(String string){
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<string.length();i++){
            String s=string.substring(i,i+1);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }
        if(map.size()>2) return 0;
        if(map.size()==1) return 1;
        return 2;
    }
}
