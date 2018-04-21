package collection;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-08-25.
 */
public class ArrayListTest {

    @Test
    public void testNull(){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }


}
