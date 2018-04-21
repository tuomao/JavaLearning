package leecode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuomao on 2017-07-13.
 */
public class SerializeTree {
    String Serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        StringBuffer trace = new StringBuffer();
        trace.append(root.val + ",");
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left == null) {
                trace.append("#,");
            } else {
                queue.add(node.left);
                trace.append(node.left.val + ",");
            }

            if (node.right == null) {
                trace.append("#,");
            } else {
                queue.add(node.right);
                trace.append(node.right.val + ",");
            }
        }
        String result = trace.toString();
        int i = result.length()-1;
        while (i >= 0) {
            if (result.charAt(i) != '#' && result.charAt(i) != ',') break;
            i--;
        }

        return result.substring(0,i+1);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) return null;

        String[] strings = str.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        for (int i = 1; i < strings.length; i += 2) {
            temp = queue.poll();
            if (strings[i].equals("#")) {
                temp.left = null;
            } else {
                temp.left = new TreeNode(Integer.valueOf(strings[i]));
                queue.add(temp.left);
            }
            if (i + 1 < strings.length) {
                if (strings[i + 1].equals("#")) {
                    temp.right = null;
                } else {
                    temp.right = new TreeNode(Integer.valueOf(strings[i + 1]));
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = Deserialize("1,2,3,#,#,4,5");
        String string = Serialize(root);
        System.out.println(string);
        root = Deserialize(string);
        string = Serialize(root);
        System.out.println(string);
    }
}
