package mutilthread;

import java.util.regex.Pattern;

/**
 * Created by tuomao on 2017-03-07.
 */
public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new YieldTest());
        Thread thread2 = new Thread(new YieldTest());
        thread1.start();
        thread2.start();
        System.out.println("main thread finish!");
    }


    static class YieldTest implements Runnable {

        @Override
        public void run() {
            int counter = 0;
            for (int i = 0; i < 5; i++) {
                counter++;
            }
            System.out.println(Thread.currentThread().getName() + "counter is:" + counter);
            Thread.currentThread().yield();
            for (int i = 0; i < 100; i++) {
                counter++;
            }
            System.out.println(Thread.currentThread().getName() + "counter is:" + counter);
        }
    }


}
