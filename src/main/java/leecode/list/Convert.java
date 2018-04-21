package leecode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuomao on 2017-06-15.
 */
public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return  null;

        List<TreeNode> nodes=new ArrayList<>();
        preOrder(pRootOfTree,nodes);


        for(int i=0;i<nodes.size();i++){
            if(i-1>=0) nodes.get(i).left=nodes.get(i-1);
            else nodes.get(i).left=null;

            if(i+1<nodes.size()) nodes.get(i).right=nodes.get(i+1);
            else  nodes.get(i).right=null;
        }

        return nodes.get(0);

    }

    public void preOrder(TreeNode root,List<TreeNode> list){
        if(root==null) return;
        preOrder(root.left,list);
        list.add(root);
        preOrder(root.right,list);
    }


}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;


    public TreeNode(int val) {
        this.val = val;

    }

}