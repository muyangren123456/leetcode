package leetcode题目分类.递归与迭代;

import leetcode题目分类.treenode.TreeNode;


import java.util.HashMap;
import java.util.Map;

public class leet106_medium {
    public static void main(String[] args) {

    }
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
         TreeNode tree = myBuild(inorder,postorder,0,n-1,0,n-1);
        return tree;
    }
    public TreeNode myBuild(int[] inorder,int[] postorder,int inorder_left,int inorder_right,
                            int postorder_left,int postorder_right){
        int postorder_root = postorder_right;
        int root_num = postorder[postorder_root];
        int order_root = indexMap.get(root_num);
        TreeNode root = new TreeNode(root_num);
        int right_size_length = inorder_right-order_root;
        root.left = myBuild(inorder,postorder,inorder_left,order_root-1,
                postorder_left,postorder_right-right_size_length-1);
        root.right = myBuild(inorder,postorder,order_root+1,inorder_right,
                postorder_right-right_size_length,postorder_right-1);
        return root;
    }
}
