package mutilthread;

import org.junit.Test;

/**
 * Created by tuomao on 2017-05-19.
 */
public class ThreadInteruptTest {


    /**
     * 通过isInterrupted来感知到中断的存在
     * 接受到了中断，但是不处理
     */
    static class Thread1 extends  Thread{

        private boolean stop=false;

        public void run() {
            // 每隔一秒检测一下中断信号量
            while (!stop) {
                System.out.println("Thread is running...");
                long time = System.currentTimeMillis();
                /*
                 * 使用while循环模拟 sleep 方法，这里不要使用sleep，否则在阻塞时会 抛
                 * InterruptedException异常而退出循环，这样while检测stop条件就不会执行，
                 * 失去了意义。
                 */
                while ((System.currentTimeMillis() - time < 1000)) {}
                // 判断线程是否检测到中断
                if(isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"检测到中断了，但是我就不处理，你能拿我怎么样");
                }
            }
            System.out.println("Thread exiting under request...");
        }
    }

    static class Thread2 extends  Thread{

        public void run() {
            // 每隔一秒检测一下中断信号量
            while (true) {
                System.out.println("Thread is running...");

                // sleep能捕获到中断的存在，并且将中断设为false
                try {
                    System.out.println("我先睡会儿");
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" 中断状态:"+isInterrupted());
                    // 这里还可以有其他的处理方式
                    return;
                }
            }
        }
    }


    public  static  void main(String[] args) throws InterruptedException {
        Thread1 thread = new Thread1();
        System.out.println("Starting thread...");
        thread.start();

        // 先让程序执行一会儿
        Thread.sleep(3000);

        // 执行时间很长了，发出中断
        thread.interrupt();
        Thread.sleep(3000);

        System.out.println("Asking thread to stop...");
        // 设置中断信号量
        thread.stop = true;
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    @Test
    public void testSleepInterupt() throws InterruptedException {
        Thread2 thread = new Thread2();
        System.out.println("Starting thread...");
        thread.start();

        // 先让程序执行一会儿
        Thread.sleep(3000);


        // 执行时间很长了，发出中断
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

}

class InterruptReset extends Object {
    public static void main(String[] args) {
        // interrupted会获取到当前线程的interrupt状态，并将该状态置为false
        System.out.println(
                "Point X: Thread.interrupted()=" + Thread.interrupted());
        // interrupt将线程的interrupt置为true
        Thread.currentThread().interrupt();
        //  这句话返回ture，但是返回之前会将interrupt置为false
        System.out.println(
                "Point Y: Thread.interrupted()=" + Thread.interrupted());
        System.out.println(
                "Point Z: Thread.interrupted()=" + Thread.interrupted());
    }
}
