package leecode.tree;

/**
 * Created by tuomao on 2017-07-13.
 */

/**
 *
 * 1. 叶子节点
 *      （1）左叶子：返回父亲节点
 *      （2）右叶子：一直到父亲节点不为右节点，往上搜索
 * 2. 非叶子节点
 *      （1）右子树为空：返回父亲节点
 *      （2）右子树不为空：返回右子树的最左节点
 *
 *
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }

        // 非叶子节点
        if(pNode.right!=null || pNode.left!=null){

            // 右子数不为空,返回右子树的最左子树
            if(pNode.right!=null){
                TreeLinkNode temp=pNode.right;
                while (temp.left!=null){
                    temp=temp.left;
                }
                return temp;
            }else{// 右子树为空，返回父亲节点
                return pNode.next;
            }
        }else {// 叶子节点

            if(pNode.next!=null){

                TreeLinkNode p=pNode.next;
                if(p.left==pNode){ // 左叶子
                    return p;
                }else {// 右叶子
                    while (p!=null && p.next!=null && p.next.right==p){
                        p=p.next;
                    }
                    return p.next;
                }
            }else{
                return null;
            }
        }

    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
