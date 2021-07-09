package main.com.java.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 106题，从中序与后序遍历序列构造二叉树
 */
public class BuildTreeByInorderPostorder {
    Map<Integer, Integer> inMap = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);//假设元素不重复，记录中序遍历元素，便于查找根结点位置
        }
        post = postorder;
        return build(0, n-1, 0, n-1);
    }

    public TreeNode build(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;//终止条件
        //从后序遍历获取根结点，拿到中序遍历下根结点的位置，计算左子树长度
        TreeNode root = new TreeNode(post[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        //构造左子树，右子树
        root.left = build(inStart, inRoot - 1, postStart, postStart + numsLeft - 1);
        root.right = build(inRoot + 1, inEnd,  postStart + numsLeft, postEnd - 1);
        return root;
    }

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class TreeNode {
        int val;
        TreeNode left,right;
        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
