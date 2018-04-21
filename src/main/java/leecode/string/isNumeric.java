package leecode.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuomao on 2017-07-10.
 */
public class isNumeric {
    public boolean isNumeric_complex(char[] str) {
        if (str == null || str.length == 0) return false;
        int i = 0;
        boolean havePoint = false;
        boolean haveE = false;
        while (i < str.length) {
            // +/-的情况
            if ((str[i] == '+' || str[i] == '-')) {
                if (i == 0 || (i>0 &&(str[i - 1] == 'e' || str[i - 1] == 'E'))) {
                    i++;
                }else {
                    return false;
                }
                continue;
            }

            // .的情况
            if (str[i] == '.') {
                if (!havePoint && i > 0 && i > 0 && i < str.length - 1 && isNumber(str[i + 1]) && !haveE) {
                    havePoint=true;
                    i++;
                }else {
                    return false;
                }
                continue;
            }

            // e的情况
            if (str[i] == 'e' || str[i] == 'E') {
                if (!haveE && i > 0 && i < str.length - 1 && isNumber(str[i - 1])
                        && (isNumber(str[i + 1]) || (str[i + 1] == '+' || str[i + 1] == '-'))){
                    haveE=true;
                    i++;
                }else {
                    return false;
                }
                continue;
            }

            // 数字情况
            if(isNumber(str[i])){
                i++;
            }else {
                return false;
            }

        }
        return true;
    }

    public boolean isNumber(char c) {
        if (c - '0' >= 0 && c - '9' <= 0) return true;
        return false;
    }


    public boolean isNumeric(char[] str){
        if(str==null || str.length==0) return false;

        String line= new String(str);
        // Java正则表达式式支持，支持后向引用，后向引用支持自定义命名
        String pattern = "^[\\+,-]*[0-9]*\\.?[0-9]*(([e,E][\\+,-]?[1-9][0-9]*)|[0-9])$";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        return m.matches();
    }

    @Test
    public void testIsNumeric(){
        System.out.println(isNumeric("+2.5e3".toCharArray()));
        System.out.println(isNumeric("+2.5e-3".toCharArray()));
        System.out.println(isNumeric("100".toCharArray()));

    }
}
