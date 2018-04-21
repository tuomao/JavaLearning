package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuomao on 2017-05-16.
 */
public class RegexMatchTest {

    @Test
    public  void testMatcher(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        // Java正则表达式式支持，支持后向引用，后向引用支持自定义命名
        String pattern = "(\\D*)(\\d+)(?<md>.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);

        if (m.find( )) {
            System.out.println(m.group("md"));
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void testBackRef(){
        String line=" MD5: C9:FC:AA:10:30:2C:E5:0A:00:81:42:D3:10:B3:C6:D9\n";
        String pattern=" *MD5: (?<md5>.*)";
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if(m.find()){
            System.out.println(m.group("md5"));
        }
    }
}
