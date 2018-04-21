package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tuomao on 2017-09-24.
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        MyList myList = new MyList();
        String string;
        while (n > 0) {
            string = scanner.nextLine();
            myList.process(string);
        }
    }


    public static class MyList {
        List<Integer> list = new LinkedList<>();
        Stack<Integer> maxList = new Stack<>();

        public int pop_back() throws Exception {
            if (list.isEmpty()) {
                throw new Exception();
            }
            if (maxList.peek() == list.get(list.size() - 1)) maxList.pop();
            int r = list.remove(list.size() - 1);
            print();
            return r;
        }

        public void print() {
            System.out.println("list:" + list.toString());
            System.out.println("maxlist:" + maxList.toString());
        }

        public int pop_front() throws Exception {
            if (list.isEmpty()) {
                throw new Exception();
            }
            int r = list.remove(0);
            if (r==(maxList.get(0))) {
                maxList.remove(0);
                if (maxList.isEmpty() && !list.isEmpty()) {
                    maxList.push(list.get(0));
                    for (int i = 1; i < list.size(); i++) {
                        if (list.get(i) >= maxList.peek()) maxList.push(list.get(i));
                    }
                }
            }
            print();
            return r;
        }

        public void push_front(Integer x) {
            while (!maxList.empty() && maxList.get(0) < x) maxList.remove(0);
            maxList.add(0, x);
            list.add(0, x);
            print();
        }

        public void push_back(int x) {
            if (maxList.empty() || maxList.peek() <= x) maxList.push(x);
            list.add(x);
            print();
        }

        public void reverse() {
            if (!list.isEmpty()) {
                int i = 0;
                int j = list.size() - 1;
                int t;
                while (i < j) {
                    t = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, t);
                    i++;
                    j--;
                }

                maxList.clear();
                maxList.add(list.get(0));
                for (i = 1; i < list.size(); i++) {
                    if (list.get(i) >= maxList.peek()) maxList.add(list.get(i));
                }
            }
            print();
        }

        public int max() throws Exception {
            if (list.isEmpty()) {
                throw new Exception();
            }

            System.out.println(maxList.peek());
            return maxList.peek();
        }

        public void process(String string) {
            String[] strings = string.split(" ");
            try {
                switch (strings[0]) {
                    case "pop_back":
                        pop_back();
                        break;
                    case "pop_front":
                        pop_front();
                        break;
                    case "push_front":
                        push_front(Integer.valueOf(strings[1]));
                        break;
                    case "push_back":
                        push_back(Integer.valueOf(strings[1]));
                        break;
                    case "max":
                        max();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error");
            }


        }

    }
}
