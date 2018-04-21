package leecode.stack;

import java.util.Stack;

/**
 * Created by tuomao on 2017-06-16.
 */
public class PushPop {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        if (!stack2.empty()) {
            return stack2.pop();
        }

        return 0;
    }
}
