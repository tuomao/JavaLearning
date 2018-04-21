package leecode.string;

/**
 * Created by tuomao on 2017-07-10.
 */
public class FirstAppearingOnce {
    static int[] map=new int[256];
    StringBuffer buffer=new StringBuffer();
    static {
        for(int i=0;i<map.length;i++) map[i]=0;
    }

    public void Insert(char ch)
    {
        map[(int)ch]++;
        buffer.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0;i<buffer.length();i++){
            if(map[(int)buffer.charAt(i)]==1) return buffer.charAt(i);
        }

        return '#';
    }
}
