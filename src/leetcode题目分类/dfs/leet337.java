package leetcode题目分类.dfs;

import leetcode题目分类.treenode.TreeNode;

import java.util.*;

public class leet337 {
    /*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房
子在同一天晚上被打劫，房屋将自动报警。

   */
    Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();
    public static void main(String[] args) {
        leet337 leet337 = new leet337();
        List<TreeNode> nodelist = new ArrayList<TreeNode>();
        Integer[] num = {3,2,3,null,3,null,1};
        for(Integer a : num){
            if (a != null){
                nodelist.add(new TreeNode(a));
            }
            else{
                nodelist.add(new TreeNode(0));
            }
        }
        System.out.println(leet337.rob(nodelist.get(0)));
    }

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node,node.val+g.getOrDefault(node.left,0)+g.getOrDefault(node.right,0));
        g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0))+
        Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
    }
}
