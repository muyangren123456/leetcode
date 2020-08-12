package leetcode题目分类.dfs;

import leetcode题目分类.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet113_medium {
    /*
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

    说明: 叶子节点是指没有子节点的节点。

    示例:
    给定如下二叉树，以及目标和 sum = 22，
     */


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curPath = new LinkedList<>();
        recur(result, curPath, root, sum);
        return result;
    }
    public void recur(List<List<Integer>> result,List<Integer> path,TreeNode node,int sum){
        if (node ==null){
            return ;
        }
        path.add(node.val);
        if (node.val == sum && node.left ==null && node.right==null){
            result.add(new ArrayList<>(path));
        }else{
            recur(result,path,node.left,sum-node.val);
            recur(result,path,node.right,sum-node.val);
        }
        path.remove(path.size()-1);
    }

}
