package leecode.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuomao on 2017-07-10.
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        String pattern = "(^(?<symbol>[+,-]?)(?<number>[1-9]+[0-9]*)$)|(?<zero>^[+,-]?0+$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            if (m.group("zero") != null) return 0;// 匹配0
            else {
                String symbol = m.group("symbol");
                String number = m.group("number");
                boolean isNegative = false;
                if (symbol != null && symbol.equals("-")) {
                    isNegative = true;
                }
                int num = 0;
                for (int i = 0; i < number.length(); i++) {
                    num = num * 10 + (number.charAt(i) - '0');
                }
                if (isNegative) {
                    num = 0 - num;
                }
                return num;
            }
        }
        return 0;

    }

    public boolean isValidStr(String str) {
        String pattern = "(^([+,-]?)([1-9]+[0-9]*)$)|(^[+,-]?0+$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) return true;

        return false;
    }

    @Test
    public void testisValidStr() {
        String pattern = "(^(?<symbol>[+,-]?)(?<number>[1-9]+[0-9]*)$)|(?<zero>^[+,-]?0+$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher("+0");
        if (m.find()) {
            System.out.println(m.group("symbol"));
            System.out.println(m.group("number"));
            System.out.println(m.group("zero"));
        }
    }

    @Test
    public void testStrToInt(){
        System.out.println(StrToInt("+123"));
        System.out.println(StrToInt("-123"));
        System.out.println(StrToInt("+-123"));
        System.out.println(StrToInt("+0123"));
        System.out.println(StrToInt("+0"));
        System.out.println(StrToInt("+123adf"));
    }
}
