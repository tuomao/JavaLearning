package leecode.tree;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-07-07.
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        if(root==null){
            return results;
        }
        traversePath(root,target,results,new ArrayList<Integer>());
        return results;
    }

    public void traversePath(TreeNode root,int target,ArrayList<ArrayList<Integer>> results,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        // 路径中添加该节点
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==root.val){
                ArrayList<Integer> p=(ArrayList<Integer>)path.clone();
                results.add(p);
            }
        }
        traversePath(root.left,target-root.val,results,path);
        traversePath(root.right,target-root.val,results,path);
        // 回溯回去
        path.remove(path.size()-1);
    }
}
