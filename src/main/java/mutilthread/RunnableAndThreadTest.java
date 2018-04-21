package mutilthread;

/**
 * Created by tuomao on 2017-03-07.
 */
public class RunnableAndThreadTest {

    static class ThreadTest extends  Thread{
        @Override
        public void run(){
            for (int i = 0; i < 5; i++)
            {
                System.out.println(Thread.currentThread().getName() + "在运行!");
            }
        }
    }

    public static void main(String[] args){
        // Th
        ThreadTest threadTest=new ThreadTest();
        Thread runnabletest=new Thread(new RunnableTest());
        threadTest.start();
        runnabletest.start();
    }

    static class RunnableTest implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 5; i++)
            {
                System.out.println(Thread.currentThread().getName() + "在运行!");
            }
        }
    }


}
