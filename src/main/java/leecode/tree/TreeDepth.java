package leecode.tree;

/**
 * Created by tuomao on 2017-07-10.
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
