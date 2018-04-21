package leecode.ReverseSentence;

/**
 * Created by tuomao on 2017-03-26.
 */
public class Solution {
    public String ReverseSentence(String str) {
        if (str != null && str.length() > 0) {
            StringBuffer result = new StringBuffer();
            int i = str.length() - 1;
            while (i >= 0) {
                int j = i;
                while (j >= 0 && str.charAt(j) != ' ') {
                    j--;
                }
                result.append(str.substring(j+1, i + 1));
                if (j > 0) {
                    result.append(' ');
                }
                i = j - 1;
            }
            return result.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ReverseSentence("student. a am I"));
    }
}
