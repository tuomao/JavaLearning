package leecode.tree;

import java.util.HashMap;

/**
 * Created by tuomao on 2017-07-13.
 */
public class KthNode {
    HashMap<TreeNode,Integer> hashMap=new HashMap<>();

    int counter=0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null) return null;
        int leftNumber=treeNumber(pRoot.left);
        if(leftNumber>=k) return KthNode(pRoot.left,k);
        else if(leftNumber==k-1) return pRoot;
        else return KthNode(pRoot.right,k-leftNumber-1);
    }

    int treeNumber(TreeNode root){
        if(root==null) return 0;
        if(hashMap.containsKey(root)) return hashMap.get(root);
        return treeNumber(root.left)+treeNumber(root.right)+1;
    }

    TreeNode KthNode1(TreeNode pRoot, int k) {
        if(pRoot==null) return null;
        TreeNode ret=KthNode1(pRoot.left,k);
        if(ret!=null) return ret;
        counter++;
        if(counter==k) return pRoot;
        ret=KthNode1(pRoot.right,k);
        if(ret!=null) return ret;

        return null;
    }



}
