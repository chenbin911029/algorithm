package main.com.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 99,重建二叉搜索树
 */
public class RebuildBST {
    public void recoverTree(TreeNode root) {
        //1.中序遍历获得nums[]
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        //2.找到错误交换位置的两个元素 int[x,y]
        int[] swapper = findTwoSwapper(nums);
        //3.恢复二叉树
        recover(root,2, swapper[0], swapper[1]);
    }

    void recover(TreeNode root, int count, int x, int y) {
        if (root == null) return;
        if (root.val == x || root.val == y) {
            //互换x,y的位置
            root.val = root.val == x ? y : x;
            //命中x,y才自减，终止条件
            if (--count == 0) return;
        }
        recover(root.left, count, x, y);
        recover(root.right, count, x, y);
    }

    int[] findTwoSwapper(List<Integer> nums) {
        int x = -1, y = -1;
        for (int i=0; i < nums.size()- 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     * 恢复二叉搜索树
     * 解题思路：
     * 1.二叉搜索树的特点，左子树 < 根节点 < 右子树
     * 2.根据中序遍历获得数组 ArrayList nums
     * List<Integer> nums = inorder(root);
     * 3.找到两个需要互换位置的元素， nums[i] > nums[i+1]
     * if (nums.get(i+1) > nums.get(i)) {
     *     y = nums.get(i+1);
     *     if (x == -1) {
     *         x = nums.get(i);
     *     } else {
     *         break;
     *     }
     * }
     * 4.重建二叉搜索树
     * recover(root,2,swappers[0],swappers[1])
     * recover(TreeNde root,int count,int x,int y) {
     *      if (root == null) return null;
     *      //根节点x,y元素互换
     *     if (root.val == x || root.val == y) {
     *         root.val = root.val == x ? y : x;
     *         //终止条件
     *         if (--count == 0) return;
     *     }
     *     recover(root.left, count, x, y);
     *     recover(root.right, count, x, y);
     * }
     */
    class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
