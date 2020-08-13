package leetcode题目分类.dfs;

import leetcode题目分类.treenode.ListNode;
import leetcode题目分类.treenode.TreeNode;
import sun.reflect.generics.tree.Tree;

public class leet109_medium复习 {
    /*有序链表转换二叉搜索树
       给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。

     */
    public TreeNode sortedListToBST(ListNode head) {
        int count =0;
        while(head !=null){
            count++;
            head = head.next;
        }
        int mid = count/2;

    }
}
