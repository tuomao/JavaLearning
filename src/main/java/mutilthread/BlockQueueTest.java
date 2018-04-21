package mutilthread;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by tuomao on 2017-08-24.
 */
public class BlockQueueTest {

    @Test
    public void testLinkedBlockQuque(){
        BlockingQueue<Integer> blockingQueue=new LinkedBlockingDeque<>(10);
    }
}
