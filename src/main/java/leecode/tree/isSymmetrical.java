package leecode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuomao on 2017-07-13.
 */
public class isSymmetrical {
    boolean isSymmetrical_false(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) return true;
        if (pRoot.left != null && pRoot.right != null) {
            Queue<TreeNode> leftQueue = new LinkedList<>();
            Queue<TreeNode> rightQueue = new LinkedList<>();
            leftQueue.add(pRoot.left);
            rightQueue.add(pRoot.right);
            while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                TreeNode leftNode = leftQueue.poll();
                TreeNode rightNode = rightQueue.poll();
                if (leftNode.val != rightNode.val) return false;
                if (leftNode.right != null) leftQueue.add(leftNode.right);
                if (leftNode.left != null) leftQueue.add(leftNode.left);
                if (rightNode.left != null) rightQueue.add(rightNode.left);
                if (rightNode.right != null) rightQueue.add(rightNode.right);
            }
            if (leftQueue.isEmpty() && rightQueue.isEmpty()) return true;
        }
        return false;
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSymmetricalCore(pRoot.left,pRoot.right);
    }

    public boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            if(left.val!=right.val) return false;
            return isSymmetricalCore(left.left,right.right) && isSymmetricalCore(left.right,right.left);
        }
        return false;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.buildTree("5,5,5,5,#,#,5,5,#,5");
        System.out.println(isSymmetrical(root));
    }
}
