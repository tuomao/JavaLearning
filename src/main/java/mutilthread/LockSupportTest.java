package mutilthread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by tuomao on 2017-08-28.
 */
public class LockSupportTest {

    public static void main(String[] args){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                new Person().walk();
            }
        });



        t.start();
        // unPark可以先于park执行，但是连续执行，只有一次有效
        LockSupport.unpark(t);
        LockSupport.unpark(t);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("我来救你了");
//        LockSupport.unpark(t);
        t.interrupt();
    }

}

class Person {

    public void walk() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "在走。。。。前面有人挡住了");
        LockSupport.park();//阻塞当前线程
        System.out.println(currentThread.getName() + "又可以走了");
        System.out.println(currentThread.getName() + "又堵住了");
        LockSupport.park();//阻塞当前线程
        System.out.println(currentThread.getName() + "又可以走了");
    }
}
