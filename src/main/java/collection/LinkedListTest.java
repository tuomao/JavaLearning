package collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by tuomao on 2017-08-25.
 */
public class LinkedListTest {

    @Test
    public void testNull(){
        LinkedList<Integer> list=new LinkedList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }
}
