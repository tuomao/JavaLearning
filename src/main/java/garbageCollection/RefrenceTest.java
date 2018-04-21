package garbageCollection;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuomao on 2017-03-15.
 */
public class RefrenceTest {

    private int[] meta=new int[500];

    public static void main(String[] args) throws InterruptedException {

       test();

    }


    public static void test(){
        RefrenceTest refrenceTest=new RefrenceTest();
        refrenceTest=null;

        List l = new LinkedList();
        System.gc();


        // Enter infinite loop which will add a String to the list: l on each
        // iteration.
        do {
            WeakReference<RefrenceTest> weakReference=new WeakReference<RefrenceTest>(new RefrenceTest());
            l.add(weakReference);
        } while (true);
    }
    protected void finalize() {
        System.out.println("Rest in Peace!");
    }


    public static void weakRefrenceTest(){
        String test=new String("12345");
        WeakReference<String> weakReference=new WeakReference<String>(test);
//        注意，在使用软引用或者是weak引用的时候，为了让对象能够被回收，需要把之前的对象给置为空
        test=null;
        System.out.println("before gc: "+weakReference.get());
        System.gc();
        System.out.println("after gc: "+weakReference.get());
    }
}
