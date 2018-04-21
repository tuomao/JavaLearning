package operator;

import org.junit.Test;

/**
 * Created by tuomao on 2017-03-03.
 */
public class OperatorTest {
    public static void main(String[] agrs){
        int a=-10;
        String string=byte2bits((byte)a);
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(a&0xff);
        System.out.println(string);
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    public static String byte2bits(byte b) {
        int z = b; z |= 256;
        String str = Integer.toBinaryString(z);
        int len = str.length();
        return str.substring(len-8, len);
    }

    @Test
    public void testOP(){
        int a= -15;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(8>>1);
        System.out.println(a >>> 1);
        System.out.println(a>>1);

    }
}
