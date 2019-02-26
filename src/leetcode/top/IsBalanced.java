package leetcode.top;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 *
 * @author Heper
 * @title 平衡二叉树
 * @date 2019/2/26 16:48
 */
public class IsBalanced {

    private boolean result = true;

    /**
     * 自底向下
     *
     * @param root
     * @return
     */
    public boolean isBalancedII(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) {
            result = false;
        }
        return 1 + Math.max(l, r);
    }

    /**
     * 自顶向上
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int nLeft = treeDepth(root.left);
            int nRight = treeDepth(root.right);
            return nLeft > nRight ? (nLeft + 1) : (nRight + 1);
        }
    }
}
