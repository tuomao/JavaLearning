package leecode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuomao on 2017-07-09.
 */

/**
 *
 * 1. 记录每一种类型的字母出现的频率
 * 2. 对于每一个迭代，都可以选择一个频率不为0的字母来进行迭代
 * 3. 当迭代的长度为字符串的长度的时候返回
 * 4. 返回的时候，需要进路径和频率都进行回溯
 *
 *
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> results=new ArrayList<>();
        if(str==null|| str.length()==0){
            return  results;
        }
        HashMap<String,Integer> maps=new HashMap<>();
        for(int i=0;i<str.length();i++){
            String key=str.substring(i,i+1);
            if(maps.containsKey(key)){
                maps.put(key,maps.get(key)+1);
            }else {
                maps.put(key,1);
            }

        }
        listPermutation(results,new StringBuffer(),maps,str.length());
        Collections.sort(results);
        return results;
    }


    public void listPermutation(ArrayList<String> results,StringBuffer buffer,HashMap<String,Integer> maps,int size) {
        if(buffer.toString().length()==size){
            results.add(new String(buffer.toString()));
            return;
        }
        for(Map.Entry<String,Integer> entry:maps.entrySet()){
            if(entry.getValue()>=1){
                maps.put(entry.getKey(),entry.getValue()-1);
                buffer.append(entry.getKey());
                listPermutation(results,buffer,maps,size);
                buffer.deleteCharAt(buffer.length()-1);
                maps.put(entry.getKey(),entry.getValue()+1);
            }
        }
    }

    @Test
    public void testPermutation(){
        System.out.println(Permutation("ab"));
        System.out.println(Permutation("aab"));
    }
}
