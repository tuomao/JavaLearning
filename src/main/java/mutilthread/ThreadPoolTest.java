package mutilthread;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tuomao on 2017-03-09.
 */
public class ThreadPoolTest {

    public static void main(String[] args){
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ArrayBlockingQueue<Objects> blockingQueue=new ArrayBlockingQueue<Objects>(5);
        SynchronousQueue<Objects> synchronousQueue=new SynchronousQueue<>();
        for(int i=0;i<5;i++){
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.incrementAndGet();
        executorService.shutdown();
    }

    static class TestRunnable implements Runnable{
        public void run(){
            System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        }
    }

    @Test
    public void testsyQueue() throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("size1:" + queue.size());
                        System.out.println("element:" + queue.take());
                        System.out.println("size2:" + queue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println(queue.offer(1));
        queue.put(1);
        System.out.println("put 1 success");
        queue.put(2);
        queue.put(3);
    }

    @Test
    public void test1() throws InterruptedException {
        SynchronousQueue<Object> queue = new SynchronousQueue<Object>();
        for(int i=0;i<5;i++){
            Thread t = new SQThread(queue, 1);
            t.start();
        }
        Thread.sleep(1000);
        for(int i=0;i<10;i++){
            queue.put("abc"+i);
            System.out.println("put success"+i);
        }
    }

    public static class SQThread extends Thread{
        private SynchronousQueue<Object> queue;
        int mode;
        SQThread(SynchronousQueue<Object> queue,int mode){
            this.queue = queue;
            this.mode = mode;
        }
        @Override
        public void run(){
            Object item = null;
            try{
                if(mode == 1){
                    while((item = queue.take()) != null){
                        System.out.println(Thread.currentThread().getId()+":"+item.toString());
                    }
                }else{
                    //
                }
            }catch(Exception e){
                //
            }
            System.out.println("end");
        }
    }
}
