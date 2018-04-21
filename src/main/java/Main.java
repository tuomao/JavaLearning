import org.junit.Test;

/**
 * Created by tuomao on 2016/9/29.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(System.currentTimeMillis());
    }

    @Test
    public void test() throws Exception {
        try {
            int a=1000;
            int b=0;
            int c=a+b;
            if(c>10) {
                throw new Exception();
            }
        }finally {
            System.out.println(1);
        }
    }
    
}
