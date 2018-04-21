package collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by tuomao on 2017-08-25.
 */
public class HashMapTest {


    @Test
    public void testNull(){
        HashMap<String,String> map=new HashMap<>();
        map.put(null,null);
        Iterator<HashMap.Entry<String,String>> it=map.entrySet().iterator();
        it.next();
    }

    @Test
    public void testHashSet(){
        HashSet<Integer> integers=new HashSet<>();
        integers.add(10);
    }

    @Test
    public void testHashTable(){
        Hashtable<String,String> hashtable=new Hashtable<>();
        hashtable.put("1","2");
    }

    @Test
    public void testTreeMap(){
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();

        treeMap.put(2,4);
        treeMap.put(1,5);
        for(Map.Entry<Integer,Integer> entry:treeMap.entrySet()){
            System.out.println(entry);
        }
    }

}
