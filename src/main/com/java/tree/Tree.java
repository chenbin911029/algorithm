package main.com.java.tree;

/**
 * 树
 */
public class Tree {

    class TreeNode {
        int val;
        TreeNode left,right;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("TreeNode value = " + root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * N叉树
     */
    class NTreeNode {
        int val;
        NTreeNode[] children;
    }

    /**
     * 遍历N叉树
     */
    void traverseNTreeNode(NTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("val = " + root.val);
        for (NTreeNode node : root.children) {
            traverseNTreeNode(node);
        }
    }

}
