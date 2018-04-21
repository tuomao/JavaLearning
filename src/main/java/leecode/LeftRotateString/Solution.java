package leecode.LeftRotateString;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str!=null&&str.length()>0) {
            StringBuffer string = new StringBuffer();
            int index = n % str.length();
            string.append(str.substring(index, str.length()));
            string.append(str.substring(0, index));
            return string.toString();
        }
        return str;
    }

    public static void main(String[] args){
        System.out.println(new Solution().LeftRotateString("abcXYZdef",3));
    }
}
