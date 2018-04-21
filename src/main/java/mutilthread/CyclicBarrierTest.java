package mutilthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by tuomao on 2017-03-14.
 */
public class CyclicBarrierTest {

    public static void main(String[] args){
        CyclicBarrier barrier=new CyclicBarrier(4,new MainTask());
        for (int i=0;i<4;i++){
            new SubTask("thread"+i,barrier).start();
        }
    }
}
/**
 * 最后执行的任务
 */
class MainTask implements Runnable {
    public void run() {
        System.out.println("......终于要执行最后的任务了......");
    }
}

/**
 * 一组并发任务
 */
class SubTask extends Thread {
    private String name;
    private CyclicBarrier cb;

    SubTask(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;
    }

    public void run() {
        System.out.println("[并发任务" + name + "]  开始执行");
        for (int i = 0; i < 999999; i++) ;    //模拟耗时的任务
        System.out.println("[并发任务" + name + "]  开始执行完毕，通知障碍器");
        try {
            //每执行完一项任务就通知障碍器
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
