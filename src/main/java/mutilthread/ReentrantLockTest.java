package mutilthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tuomao on 2017-03-14.
 */
public class ReentrantLockTest {

    static class AutomticAdd{
        int counter=0;
        ReentrantLock lock=new ReentrantLock();
        public int add(){
            lock.lock();
            try {
                Thread.sleep(1000);
                counter++;
                System.out.println("counter value is " + counter);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            return counter;
        }

        public int add1(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            System.out.println("counter value is " + counter);
            return  counter;
        }
    }

    static class AutomticAddRunnable implements Runnable{

        private  AutomticAdd counter;

        public AutomticAddRunnable(AutomticAdd counter){
            this.counter=counter;
        }

        @Override
        public void run() {
            for(;;){
                int result=counter.add1();
            }
        }
    }





    public static void main(String[] args){
        AutomticAdd counter=new AutomticAdd();

        for(int i=0;i<10;i++){
            Thread thread=new Thread(new AutomticAddRunnable(counter));
            thread.start();
        }
    }
}
