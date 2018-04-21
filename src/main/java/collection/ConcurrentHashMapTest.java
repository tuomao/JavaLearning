package collection;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tuomao on 2017-08-25.
 */
public class ConcurrentHashMapTest {

    @Test
    public void testConcurrentHashMap(){
        ConcurrentHashMap<String,String > map=new ConcurrentHashMap<>();
        map.put("1","2");
    }
}
