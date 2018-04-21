package leecode.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tuomao on 2017-07-09.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length()==0){
            return -1;
        }
        LinkedHashMap<String,Integer> map=new LinkedHashMap<>(str.length()*2,(float)0.5);
        for(int i=0;i<str.length();i++){
            String key=String.valueOf(str.charAt(i));
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
