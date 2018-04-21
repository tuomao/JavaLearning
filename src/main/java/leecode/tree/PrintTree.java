package leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tuomao on 2017-07-13.
 */
public class PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (pRoot == null) return results;
        Queue<TreeNode> tempQueue = new LinkedList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        tempQueue.add(pRoot);
        tempStack.add(pRoot);
        printCore(tempStack, tempQueue, 1, results);
        return results;
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (pRoot == null) return results;
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(pRoot);
        printCore1(tempQueue,results);
        return results;
    }

    public void printCore1(Queue<TreeNode> queue, ArrayList<ArrayList<Integer>> results) {
        if (!queue.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();

            ArrayList<Integer> lines = new ArrayList<>();
            results.add(lines);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                lines.add(node.val);
                if (node.left != null) {
                    tempQueue.add(node.left);

                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }
            }
            printCore1(tempQueue, results);
        }
    }

    public void printCore(Stack<TreeNode> stack, Queue<TreeNode> queue, int line, ArrayList<ArrayList<Integer>> results) {
        if (!stack.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            ArrayList<Integer> lines = new ArrayList<>();
            results.add(lines);
            if (line % 2 == 1) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    lines.add(node.val);
                    if (node.left != null) {
                        tempQueue.add(node.left);
                        tempStack.add(node.left);
                    }
                    if (node.right != null) {
                        tempQueue.add(node.right);
                        tempStack.add(node.right);
                    }
                }
            } else {
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    lines.add(node.val);
                }
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        tempQueue.add(node.left);
                        tempStack.add(node.left);
                    }
                    if (node.right != null) {
                        tempQueue.add(node.right);
                        tempStack.add(node.right);
                    }
                }
            }
            printCore(tempStack, tempQueue, line + 1, results);
        }
    }
}
