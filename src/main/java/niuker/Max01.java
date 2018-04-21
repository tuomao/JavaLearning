package niuker;

import java.util.Scanner;

/**
 * Created by tuomao on 2017-08-16.
 */
public class Max01 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();

        System.out.println(new Max01().getResult(string));

    }

    public int getResult(String string){
        if(string==null|| string.length()==0) return 0;
        int i=1;
        int max=1;
        int curLength=1;
        while (i<string.length()){
            if(string.charAt(i)==string.charAt(i-1)){
                curLength++;
            }
            else {
                if(max<curLength) max=curLength;
                curLength=1;
            }
            i++;
        }
        return max;
    }

}
