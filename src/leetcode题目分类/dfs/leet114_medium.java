package leetcode题目分类.dfs;

import leetcode题目分类.treenode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leet114_medium {
    /*
    给定一个二叉树，原地将它展开为一个单链表。
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node !=null || !stack.isEmpty()){
            while (node !=null){
                list2.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int num = list2.size();
        for (int i = 1; i < num; i++) {
            TreeNode prev = list2.get(i-1) ,curr = list2.get(i);
            prev.left =null;
            prev.right =curr;
        }
    }
}
