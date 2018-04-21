package ali;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tuomao on 2017-03-03.
 */
public class Ali {

    static String decrypt(String s) {
        String[] strings=s.split(",");
        ArrayList<Integer> list=new ArrayList<>();
        for(String string:strings) {
            int i = Integer.valueOf(string);
            byte[] bytes = intToByteArray(i);
            byte ramdomNumber = bytes[2];
            byte actualNumber = bytes[3];

            int randomInt = byteToInt(ramdomNumber);
            randomInt = ~randomInt;

            int actualInt = byteToInt(actualNumber);
            actualInt = randomInt + actualInt;
            list.add(0, actualInt);
        }
        byte[] bytes=new byte[list.size()];
        for (int i=0;i<list.size();i++){
            int number=~list.get(i);
            bytes[i]=intToByte(number);
        }
        String string=String.valueOf(bytes);
        return string;
    }

    public static byte intToByte(int x) {
        return (byte) x;
    }


    public static int byteToInt(byte b) {
        return b & 0xFF;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = decrypt(_s);
        System.out.println(res);
    }


    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }
}
