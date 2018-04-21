package javabasic;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by tuomao on 2017-09-02.
 */
public class RefrenceTest {
    @Test
    public void testSoftRef() throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        SoftReference<Object> softRef = new SoftReference<Object>(obj, refQueue);
        System.out.println(softRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        // 清除强引用,触发GC
        obj = null;
        System.gc();

        System.out.println(softRef.get());

        Thread.sleep(200);
        System.out.println(refQueue.poll());
    }

    @Test
    public void testWeakRef() throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        WeakReference<Object> weakRef = new WeakReference<Object>(obj, refQueue);
        System.out.println(weakRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        // 清除强引用,触发GC
        obj = null;
        System.gc();

        System.out.println(weakRef.get());

        // 这里特别注意:poll是非阻塞的,remove是阻塞的.
        // JVM将弱引用放入引用队列需要一定的时间,所以这里先睡眠一会儿
        // System.out.println(refQueue.poll());// 这里有可能是null

        Thread.sleep(200);
        System.out.println(refQueue.poll()); // 将weakRefrence对象从引用队列之中移除，引用队列的对象销毁
    }

    @Test
    public void phantom() throws Exception
    {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantom = new PhantomReference<Object>(obj,
                refQueue);
        System.out.println(phantom);
        System.out.println(phantom.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        obj = null;
        System.gc();

        // 调用phanRef.get()不管在什么情况下会一直返回null
        System.out.println(phantom.get());

        // 当GC发现了虚引用，GC会将phanRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phanRef所引用的obj对象，并没有被GC回收，在我们显式地调用refQueue.poll返回phanRef之后
        // 当GC第二次发现虚引用，而此时JVM将phanRef插入到refQueue会插入失败，此时GC才会对obj进行回收
        Thread.sleep(200);
        // 此时PhantomReference.refrent并不为空
        System.out.println(refQueue.poll());
    }

    @Test
    public void testPhantom(){

    }
}
