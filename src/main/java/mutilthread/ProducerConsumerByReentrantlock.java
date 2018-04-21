package mutilthread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tuomao on 2017-03-14.
 */
public class ProducerConsumerByReentrantlock {


    static class ItemHolder{
        ArrayList<Integer> queue=new ArrayList<>();
        int maxSize=10;
        int counter=0;
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();

        private void produce(){

            // 模拟生产者生产的过程，只有放物品的时候才需要去锁住对象
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                while(queue.size()>maxSize){
                    System.out.println("生产者"+Thread.currentThread().getName()+"进入等待");
                    condition.await();
                }
                counter++;
                queue.add(counter);
                System.out.println("生产者"+Thread.currentThread().getName()+"生产了物品："+counter);
                condition.signal();
                condition.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }


        public void consume(){
            lock.lock();
            try {
                while (queue.size()==0){
                    System.out.println("消费者"+Thread.currentThread().getName()+"进入等待");
                    condition.await();
                }
                System.out.println("消费者"+Thread.currentThread().getName()+"消费了物品：" + queue.remove(0));
                condition.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            // 消费者拿到物品之后就可以进行吃了，只需要锁拿物品的过程，模拟消费者吃的过程
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Producer implements Runnable{

        private ItemHolder holder;

        public Producer(ItemHolder holder){
            this.holder=holder;
        }

        @Override
        public void run() {
            while (true) {
                holder.produce();
            }
        }
    }


    static class Comsumer implements Runnable{

        private ItemHolder holder;

        public Comsumer(ItemHolder holder){
            this.holder=holder;
        }

        @Override
        public void run() {
            while (true) {
                holder.consume();
            }
        }
    }

    public static void main(String[] args){
        ItemHolder holder=new ItemHolder();
        for(int i=0;i<5;i++){
            new Thread(new Producer(holder)).start();
        }
        for(int i=0;i<5;i++){
            new Thread(new Comsumer(holder)).start();
        }
    }

}
