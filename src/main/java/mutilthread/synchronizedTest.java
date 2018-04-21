package mutilthread;

/**
 * Created by tuomao on 2017-03-07.
 */
public class synchronizedTest {
    public static class Student {
        public synchronized void print1() {
            System.out.println("Student.print1()");
            print2();
        }

        public synchronized void print2() {
            System.out.println("Student.print2()");
            print3();
        }

        public synchronized void print3() {
            System.out.println("Student.print3()");
        }

        public synchronized void methodA() {
            try {
                System.out.println("Begin methodA, threadName = " +
                        Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("End methodA, threadName = " +
                        Thread.currentThread().getName() + ", end Time = " +
                        System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void methodC() {
            try {
                System.out.println("Begin methodC, threadName = " +
                        Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("End methodC, threadName = " +
                        Thread.currentThread().getName() + ", end Time = " +
                        System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void methodB() {
            try {
                System.out.println("Begin methodB, threadName = " +
                        Thread.currentThread().getName() + ", begin time = " +
                        System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("End methodB, threadName = " +
                        Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test4();
    }

    /**
     * 拥有对象锁的方法和没有拥有对象锁的方法不会产生阻塞
     */
    public static void test1() {
        Student student = new Student();
        Thread threadA = new Thread(new RunnableMethodA(student));

        // MethodB不用获取对象锁，因此不会因为methodA还没有释放锁而阻塞
        Thread threadB = new Thread(new RunnableMethodB(student));
        threadA.start();
        threadB.start();

    }

    /**
     * 同样需要对象锁的方法之间会发生阻塞
     */
    public static void test2() {
        Student student = new Student();
        // 因为methodC需要等待methodA完全执行完成以后才能继续执行
        Thread threadA = new Thread(new RunnableMethodA(student));
        Thread threadC = new Thread(new RunnableMethodC(student));

        threadA.start();
        threadC.start();
    }

    /**
     * 死锁测试
     */
    public static void test3() {
        final DeadlockRisk deadlockRisk = new DeadlockRisk();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadlockRisk.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadlockRisk.write(10, 24);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void test4() {
        final WaiteNotifyTest waiteNotifyTest = new WaiteNotifyTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waiteNotifyTest.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waiteNotifyTest.write(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    static class RunnableMethodA implements Runnable {

        private Student student;

        public RunnableMethodA(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            student.methodA();
        }
    }

    static class RunnableMethodB implements Runnable {

        private Student student;

        public RunnableMethodB(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            student.methodB();
        }
    }

    static class RunnableMethodC implements Runnable {

        private Student student;

        public RunnableMethodC(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            student.methodC();
        }
    }


    public static class DeadlockRisk {
        private static class Resource {
            public int value = 0;
        }

        private Resource resourceA = new Resource();
        private Resource resourceB = new Resource();

        public int read() throws InterruptedException {
            synchronized (resourceA) {

                synchronized (resourceB) {
                    if (resourceA.value == 0 || resourceB.value == 0) {
                        resourceA.wait();
                        resourceB.wait();
                    }
                    int result = resourceB.value + resourceA.value;
                    System.out.println("value is " + result);
                    return result;
                }
            }
        }

        public void write(int a, int b) throws InterruptedException {
            synchronized (resourceB) {
                synchronized (resourceA) {
                    resourceA.value = a;
                    resourceB.value = b;
                    resourceA.notify();
                    resourceB.notify();
                }
            }
        }
    }

    public static class WaiteNotifyTest {
        private static class Resource {
            public int value = 0;
        }

        private Resource resourceA = new Resource();

        public void read() throws InterruptedException {
            synchronized (resourceA) {
                while (resourceA.value == 0) {
                    resourceA.wait();
                }
                System.out.println("result is" + resourceA.value);
            }

        }

        public void write(int a) throws InterruptedException {
            synchronized (resourceA) {
                resourceA.value = a;
                System.out.println("set value="+a);
                resourceA.notify();
            }
        }
    }
}
