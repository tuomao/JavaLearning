package leecode.string;

import org.junit.Test;

/**
 * Created by tuomao on 2017-06-16.
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str==null) return  null;
        if(str.length()==0) return "";
        StringBuffer buffer=new StringBuffer();
        int i=0;
        while (i<str.length()){
            if(str.charAt(i)==' '){
                buffer.append("%20");
            }else{
                buffer.append(str.substring(i,i+1));
            }
            i++;
        }
        return buffer.toString();
    }


    @Test
    public void test(){
        System.out.println(replaceSpace(new StringBuffer("hello world")));
        System.out.println(replaceSpace(new StringBuffer("    hello    wor   ")));
        System.out.println(replaceSpace(new StringBuffer("      ")));
    }
}
