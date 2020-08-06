package leetcode题目分类.dfs;

import leetcode题目分类.treenode.TreeNode;

public class leet104_easy {
    /*
    给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
示例：
给定二叉树 [3,9,20,null,null,15,7]，

     */
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int depth = dfs(0,root);
        return depth;
    }
    public int dfs(int depth,TreeNode node){
        if(node.left ==null && node.right==null){
            return depth;
        }
        depth++;
        depth = Math.max(dfs(depth,node.left),dfs(depth,node.right));
        return depth;
    }
}
