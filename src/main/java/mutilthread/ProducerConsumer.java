package mutilthread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuomao on 2017-03-07.
 */
public class ProducerConsumer {
    static class Producer implements Runnable{
        private List<String> container;
        private int maxSize;

        public Producer(List<String> container, int maxSize) {
            this.container = container;
            this.maxSize = maxSize;
        }


        public void run() {
            int counter=0;
            while (true){
                try {
                    produce(counter++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void produce(int i) throws InterruptedException {
            synchronized (container){
                while (container.size()>maxSize){
                    System.out.println(Thread.currentThread().getName()+":生产者的容器已经满了");
                    container.wait();
                }
                Thread.sleep(500);
                container.add("cook"+i);
                System.out.println(Thread.currentThread().getName() + "生产者生产了"+container.get(container.size()-1));

                container.notifyAll();
            }

        }

    }

    static class Consumer implements Runnable{


        private List<String> container;
        private String name;

        public Consumer(List<String> container,String name) {
            this.container = container;
            this.name=name;
        }

        @Override
        public void run() {
            while (true){
                try {
                    consume();
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void consume() throws InterruptedException {
            synchronized (container){
                while (container.size()==0){
                    System.out.println(Thread.currentThread().getName()+":"+name+"把东西吃完了");

                    container.wait();

                }
                System.out.println(Thread.currentThread().getName()+":"+name+"消费了"+container.get(0));
                container.remove(0);
                container.notifyAll();
            }
        }
    }

    public static void main(String[] args){
        ArrayList<String> container=new ArrayList<>();
        Thread thread1=new Thread(new Producer(container,5));
        Thread thread2=new Thread(new Consumer(container,"客户1"));
        Thread thread3=new Thread(new Consumer(container,"客户2"));
        thread1.start();
//        thread2.start();
//        thread3.start();
    }
}
