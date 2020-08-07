package leetcode题目分类.递归与迭代;

import leetcode题目分类.treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class leet105_medium {
    /*
    根据一棵树的前序遍历与中序遍历构造二叉树。
    注意:
    你可以假设树中没有重复的元素。

    例如，给出
    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
     */
    public static void main(String[] args) {
        int[] preorder ={3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        leet105_medium leet105_medium = new leet105_medium();
        System.out.println(leet105_medium.buildTree(preorder,inorder));
    }
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n =preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,int inorder_left, int inorder_right) {
        if(preorder_left>preorder_right){
            return null;
        }
        int preorder_root = preorder_left;
        int head = preorder[preorder_left];
        int inorder_root = indexMap.get(head);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(head);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left + size_left_subtree,inorder_left,inorder_root-1);

        root.right = myBuildTree(preorder,inorder,preorder_left +size_left_subtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }

}
