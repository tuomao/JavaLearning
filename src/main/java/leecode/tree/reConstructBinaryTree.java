package leecode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuomao on 2017-06-16.
 */
public class reConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null|| in==null|| pre.length==0||in.length==0||pre.length!=in.length) return null;
        return reConstructBinaryTree(pre,0,pre.length,in,0,in.length);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int pl,int pr,int [] in,int il,int ir){
        if(pl==pr) return null;

        TreeNode root=new TreeNode(pre[pl]);

        int i=il;
        while (i<ir){
            if(in[i]==pre[pl]) break;
            i++;
        }
        root.left=reConstructBinaryTree(pre,pl+1,pl+1+i-il,in,il,i);
        root.right=reConstructBinaryTree(pre,pl+1+i-il,pr,in,i+1,ir);
        return root;
    }

    @Test
    public void testBuildTree(){
        TreeNode root=TreeNode.buildTree("5,5,5,5,#,#,5,5,#,5");
        TreeNode.printTree(root);
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode buildTree(String string){
        String[] strings=string.split(",");
        TreeNode root=new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        for(int i=1;i<strings.length;i+=2){
            temp=queue.poll();
            if(strings[i].equals("#")) {
                temp.left=null;
            }else {
                temp.left=new TreeNode(Integer.valueOf(strings[i]));
                queue.add(temp.left);
            }
            if(i+1<strings.length){
                if(strings[i+1].equals("#")) {
                    temp.right=null;
                }else {
                    temp.right=new TreeNode(Integer.valueOf(strings[i+1]));
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }
    public static void printTree(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode node=null;
        StringBuffer trace=new StringBuffer();
        trace.append(root.val+",");
        while (!queue.isEmpty()){
            node=queue.poll();
            if(node.left==null){
                trace.append("#,");
            }else {
                queue.add(node.left);
                trace.append(node.left.val+",");
            }

            if(node.right==null){
                trace.append("#,");
            }else {
                queue.add(node.right);
                trace.append(node.right.val+",");
            }
        }
        System.out.println(trace.toString());
    }


}

