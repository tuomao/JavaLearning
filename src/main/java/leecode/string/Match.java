package leecode.string;

import org.junit.Test;

/**
 * Created by tuomao on 2017-07-10.
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null || str.length == 0 || pattern.length == 0) return false;
        return matchCore(str, pattern, 0, 0);
    }

    public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
        System.out.println(strIndex+";"+patternIndex);
        if (strIndex == str.length && patternIndex == pattern.length) return true;

        if (strIndex != str.length && patternIndex == pattern.length) return false;

        if(strIndex==str.length && patternIndex!=pattern.length){
            if(patternIndex+1<pattern.length && pattern[patternIndex+1]=='*')
                return matchCore(str, pattern, strIndex, patternIndex + 2);
            return  false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*') {
            // 匹配的情况
            if ((pattern[patternIndex] == '.' &&strIndex!=str.length) || pattern[patternIndex] == str[strIndex]) {
                return matchCore(str, pattern, strIndex, patternIndex + 2) || // 0次
                        matchCore(str, pattern, strIndex + 1, patternIndex + 2) ||// 1次
                        matchCore(str, pattern, strIndex + 1, patternIndex); // 继续使用该模式
            } else {// 不匹配的情况
                return matchCore(str, pattern, strIndex, patternIndex + 2);
            }
        }
        if ((pattern[patternIndex] == '.' && strIndex!=str.length) || pattern[patternIndex] == str[strIndex])
            return matchCore(str, pattern, strIndex + 1,patternIndex + 1 );
        return false;
    }

    @Test
    public void testMatch() {
//        System.out.println(match("abb".toCharArray(), "ab*".toCharArray()));
//        System.out.println(match("abbc".toCharArray(), "ab*.*".toCharArray()));
//        System.out.println(match("abbcccef".toCharArray(), "ab*.*.*f".toCharArray()));
//        System.out.println(match("abb".toCharArray(), "ab*g".toCharArray()));
        System.out.println(match("aaa".toCharArray(), "ab*a".toCharArray()));
    }
}
