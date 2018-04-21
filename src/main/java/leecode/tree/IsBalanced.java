package leecode.tree;

/**
 * Created by tuomao on 2017-07-10.
 */
public class IsBalanced {
    private boolean flag = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        treeHeight(root);
        return flag;
    }

    public int treeHeight(TreeNode root) {
        if (root == null || flag == false) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
