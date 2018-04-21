package leecode.HasSubtree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuomao on 2017-03-14.
 */
public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root1PreOrder = new ArrayList<>();
        ArrayList<Integer> root1MiddleOrder = new ArrayList<>();
        ArrayList<Integer> root2PreOrder = new ArrayList<>();
        ArrayList<Integer> root2MiddleOrder = new ArrayList<>();

        preOrder(root1, root1PreOrder);
        middleOrder(root1, root1MiddleOrder);
        preOrder(root2, root2PreOrder);
        middleOrder(root2, root2MiddleOrder);

        boolean preOrderContain = containString(root1PreOrder, root2PreOrder);
        boolean middlerOrderContain = containString(root1MiddleOrder, root2MiddleOrder);
        if (preOrderContain && middlerOrderContain) {
            return true;
        }
        return false;
    }

    public boolean HasSubtree3(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> roo1WideTrace = wideTrace(root1);
        ArrayList<Integer> root2WideTrace = wideTrace(root2);
        boolean result = containString(roo1WideTrace, root2WideTrace);

        return result;
    }


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            boolean result = false;
            if (root1.val == root2.val) {
                result = treeEqual(root1, root2);
                if (result) {
                    return true;
                }
            }
            result = HasSubtree(root1.left, root2);
            if (result) {
                return true;
            }
            result = HasSubtree(root1.right, root2);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public boolean treeEqual(TreeNode roo1, TreeNode roo2) {
        if (roo1 != null && roo2 != null) {
            if (roo1.val == roo2.val) {
                return treeEqual(roo1.left, roo2.left) && treeEqual(roo1.right, roo2.right);
            }
        } else if ((roo1 == null && roo2 == null) || (roo1 != null && roo2 == null)) {
            return true;
        }
        return false;
    }


    public boolean containString(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        while (i < (a.size() - b.size())) {
            int j = i;
            boolean flag = true;
            for (int k = 0; k < b.size(); k++) {
                if (a.get(j) == b.get(k)) {
                    j++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void preOrder(TreeNode root, ArrayList<Integer> sequence) {
        if (root != null) {
            preOrder(root.left, sequence);
            sequence.add(root.val);
            preOrder(root.right, sequence);
        }
    }

    public void middleOrder(TreeNode root, ArrayList<Integer> sequence) {
        if (root != null) {
            sequence.add(root.val);
            middleOrder(root.left, sequence);
            middleOrder(root.right, sequence);
        }
    }

    public ArrayList<Integer> wideTrace(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            TreeNode node;
            while ((node = queue.poll()) != null) {
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        char[] chars1={'#',8,8,7,9,2,'#','#','#','#',4,7};
        char[] chars2={'#',8,9,2};
        TreeNode roo1 = createTree(chars1,1);

        TreeNode roo2 = createTree(chars2,1);
        Solution solution = new Solution();
        boolean result = solution.HasSubtree(roo1, roo2);
        System.out.println(result);
    }

    public static TreeNode createTree(char[] chars,int i) {
        if(chars[i]!='#'){
            TreeNode node=new TreeNode(chars[i]);
            if(2*i<chars.length){
                node.left=createTree(chars,2*i);
            }
            if(2*i+1<chars.length){
                node.right=createTree(chars,2*i+1);
            }
            return node;
        }
        return  null;
    }
}
