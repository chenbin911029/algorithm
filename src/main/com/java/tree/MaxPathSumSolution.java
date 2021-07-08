package main.com.java.tree;
import org.junit.Test;
/**
 * LeetCode 124 题
 * 给定一个非空二叉树，返回其最大路径和
 */
public class MaxPathSumSolution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideSum(root);
        return ans;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    int oneSideSum(TreeNode root) {
        //终止条件
        if (root == null) {
            return 0;
        }
        //看左边，右边的最大值，如果小于0则不加，所以取0
        int leftMax = Math.max(0, oneSideSum(root.left));
        int rightMax = Math.max(0, oneSideSum(root.right));
        //记录最大值，并更新
        ans = Math.max(ans, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }

    /**
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     * 递归左右子树得到单路径最大和，然后和记录的sum做比较，每次替换最大的值
     * @param root
     * @return
     */
    /**
     * 思路：
     * 求路径最大和，可能的情况：
     * 1.左子树
     * 2.右子树
     * 3.当前节点val
     * 4.左子树 + 右子树 + 当前节点.val
     */

    @Test
    public void test() {
        //[9,3,15,20,7]
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(15);
        TreeNode right1Left = new TreeNode(20);
        TreeNode right1Right = new TreeNode(7);

        root.left = left1;
        root.right = right1;
        right1.left = right1Left;
        right1.right = right1Right;

        System.out.println(maxPathSum(root));
    }

    class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
