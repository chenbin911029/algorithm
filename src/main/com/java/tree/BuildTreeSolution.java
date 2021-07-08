package main.com.java.tree;
import java.util.HashMap;
import java.util.Map;
/**
 * LeetCode 105题
 * 根据一棵树的前序遍历，中序遍历，构造二叉树
 */
public class BuildTreeSolution {

    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //假设二叉树中的元素不重复
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(inorder[i], i);
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    //构建左子树，右子树
    TreeNode build(int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //终止条件
        if (preStart > preEnd  || inStart > inEnd) return null;
        //获取根结点的index，左子树长度
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = indexMap.get(root.val);
        int numsLeft = inRoot - inStart;
        //构建左子树
        root.left = build(preorder, preStart +1, preStart + numsLeft, inorder, inStart, inRoot - 1);
        //构建右子树
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);
        return root;
    }

    /**
     * 例如，给出
     *
     * 前序遍历 preorder =[3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class TreeNode {
        int val;
        TreeNode left,right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
