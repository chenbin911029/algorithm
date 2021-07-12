package main.com.java.tree;

import org.junit.Test;

/**
 * 树
 */
public class Tree {

    class TreeNode {
        int val;
        TreeNode left,right;
    }

    @Test
    public void testInorder() {
        TreeNode root = new TreeNode();
        root.val = 3;
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode leftChildRight = new TreeNode();
        leftChildRight.val = 2;
        root.left = left;
        left.right = leftChildRight;
        inOrder(root);
    }


    /**
     * 先序遍历
     * @param root
     */
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("TreeNode value = " + root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * 左子树，根节点，右子树
     * @param root
     */
    void inOrder(TreeNode root) {
        if (root == null) {
            //终止条件
            return;
        }
        inOrder(root.left);
        System.out.println("val=" + root.val);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * 左子树，右子树，根节点
     * @param root
     */
    void postOrder(TreeNode root) {
        //终止条件
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("val = " + root.val);
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
