package mutilthread;

import org.junit.Test;

/**
 * Created by tuomao on 2017-08-26.
 */
public class Volitaletest {

    public volatile int abd;
    public int abc;

    @Test
    public void func(){
        Volitaletest volitaletest=new Volitaletest();
        int i=1;
        volitaletest.abd=0;
        int c=volitaletest.abd+1;
    }

    @Test
    public void fun1(){
        Volitaletest volitaletest=new Volitaletest();
        int i=1;
        volitaletest.abc=0;
        int c=volitaletest.abc+1;
    }


    private volatile static Volitaletest instance;
    public static Volitaletest getInstance() {
        if (instance == null) {
            synchronized (Volitaletest.class) {
                if (instance == null) {
                    int a = 1;  // 1
                    int b = 2;  // 2
                    instance = new Volitaletest();  // 3
                    int c = a + b;  // 4
                }
            }
        }
        return instance;
    }


}
