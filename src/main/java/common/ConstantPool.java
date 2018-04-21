package common;

import org.junit.Test;

import static jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.getObjectSize;

/**
 * Created by tuomao on 2017-09-01.
 */
public class ConstantPool {

    @Test
    public void testStringConstant(){
        String a="a"+"b";
        String b="ab";
        System.out.println(a==b);
    }

    @Test
    public void TestFinal(){
        A a=new A();
        System.out.println(getObjectSize(a));
    }

    static class A{
//        final int a=1;


    }
}
