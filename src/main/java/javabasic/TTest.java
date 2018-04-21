package javabasic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tuomao on 2017-09-02.
 */
public class TTest {
    @Test
    public void testArray() {
        Object[] array = new String[10];
        array[0] = 10;
    }

    public static <T extends Comparable<? super T>> void sort1(ArrayList<T> list) {
        Collections.sort(list);
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        Collections.sort(list);
    }

    @Test
    public void test1() {
        ArrayList<Anamal> list = new ArrayList<>();
        list.add(new Anamal(10));
        list.add(new Dog(15));
        sort(list);
        sort1(list);

        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog(5));
        dogs.add(new Dog(18));
//        这语句有问题，因为Dog没有implement<Dog>，只要是T的父类都可以
// 所以要用 <T extends Comparable<? super T>>
//        sort(dogs);
    }

    public static class Anamal implements Comparable<Anamal> {

        int age;

        public Anamal(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Anamal o) {
            return this.age - o.age;
        }
    }

    public static class Dog extends Anamal {


        public Dog(int age) {
            super(age);
        }
    }
}
