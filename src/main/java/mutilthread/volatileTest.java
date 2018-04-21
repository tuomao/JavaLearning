package mutilthread;

/**
 * Created by tuomao on 2017-03-09.
 */
public class volatileTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        Thread mt = new Thread(myThread);
        mt.start();
        Thread.sleep(1000);
        myThread.setFlag(false);
        System.out.println("已赋值为false");
    }

    static class MyThread implements Runnable{

//        private volatile boolean flag=true;
        private  boolean flag=true;

        public void setFlag(boolean flag){
            this.flag=flag;
        }

        @Override
        public void run() {
            System.out.println("进入run了");
            while (flag == true){}
            // 如果不加volatile关键字，flag的修改对于新建出来的线程是不可见的
            System.out.println("线程被停止了");
        }
    }
}
