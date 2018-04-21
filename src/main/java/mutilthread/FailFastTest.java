package mutilthread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tuomao on 2017-09-01.
 */
public class FailFastTest {

    @Test
    public void testFailFast() throws InterruptedException {

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(i);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(1200);
            }
        }).start();
        Iterator<Integer> iterator=list.iterator();
        try {
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                Thread.sleep(200);
            }
        }catch (ConcurrentModificationException e){
            System.out.println("catch exception");
            e.printStackTrace();
        }

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList=new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(10);

    }
}
