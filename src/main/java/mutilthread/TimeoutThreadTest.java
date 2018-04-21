package mutilthread;

import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by tuomao on 2017-05-19.
 */
public class TimeoutThreadTest {

    @Test
    public void testCallbackTimeOut() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Task task1 = new Task(1000);
        Task task2 = new Task(8000);

        List<Task> tasks = new LinkedList<>();
        tasks.add(task1);

        for (Task task : tasks) {
            Future future = executor.submit(task);
            try {
                System.out.println("Started..");
                System.out.println(future.get(2, TimeUnit.SECONDS));
                System.out.println("Finished!");
            } catch (TimeoutException e) {
                future.cancel(true);
                System.out.println("Terminated!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }


    @Test
    public void testDamonTimeOut(){

        TimeoutThread t = new TimeoutThread(5000,new MyTimeoutException("超时"));
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(Thread.currentThread().getName()+"处理了这个异常");
            }
        });
        try{
            t.start();
            int i=0;
            while(i<10){

                long start=new Date().getTime();
                while((new Date().getTime()-start)<1000){
                }
                i++;
                System.out.println(Thread.currentThread().getName()+i);
            }
            t.cancel();

        }catch (MyTimeoutException e) {
            System.out.println("执行超时");
        }
    }

}


class Task implements Callable {
    private int workTime;
    private Thread curThread;

    public Task(int workTime) {
        curThread = Thread.currentThread();
        this.workTime = workTime;
    }


    @Override
    public String call() throws Exception {
        try {
            long time = new Date().getTime();
            // 一直工作
            while ((new Date().getTime() - time) < workTime) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断");
                }
            }
            System.out.println(Thread.currentThread().getName() + "工作完成");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return "finish!";
    }
}


class TimeoutThread extends Thread {
    /**
     * 计时器超时时间
     */
    private long timeout;
    /**
     * 计时是否被取消
     */
    private boolean isCanceled = false;
    /**
     * 当计时器超时时抛出的异常
     */
    private MyTimeoutException timeoutException;

    /**
     * 构造器
     *
     * @param timeout 指定超时的时间
     */
    public TimeoutThread(long timeout, MyTimeoutException timeoutErr) {
        super();
        this.timeout = timeout;
        this.timeoutException = timeoutErr;
        //设置本线程为守护线程
//        this.setDaemon(true);
    }

    /**
     * 取消计时
     */
    public synchronized void cancel() {
        isCanceled = true;
    }

    /**
     * 启动超时计时器
     */
    public void run() {
        try {
            Thread.sleep(timeout);
            if (!isCanceled) {
                System.out.println(Thread.currentThread().getName()+"超时");
                throw timeoutException;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyTimeoutException extends RuntimeException {
    /**
     * 序列化号
     */
    private static final long serialVersionUID = -8078853655388692688L;
    public MyTimeoutException(String errMessage)
    {
        super(errMessage);
    }
}