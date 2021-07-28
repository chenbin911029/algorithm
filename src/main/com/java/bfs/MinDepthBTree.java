package main.com.java.bfs;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;
/**
 * LeetCode 111
 * 给定一颗二叉树，找出其最小深度
 * 解题思路： 叶子节点：没有子节点，二叉树中 root.left == null && root.right == null 则为叶子节点
 */
public class MinDepthBTree {
    public int minDepth(TreeNode root) {
        //终止条件，空判断
        if (root == null) return 0;
        //用队列记录树节点
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //root初始深度
        int depth = 1;
        //广度遍历
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //取出当前节点
                TreeNode cur = q.poll();
                //到达叶子节点，终止条件
                if (cur.left == null && cur.right == null) return depth;
                //加入相邻节点
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            depth++;//深度+1
        }
        return depth;
    }

    @Test
    public void testMinDepth() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode right_left = new TreeNode(15);
        TreeNode right_right = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = right_left;
        right.right = right_right;
        left.left = right_left;
        left.right = right_right;

        System.out.println(minDepth(root));
    }

    class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
