package sword.offer;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @Author : Heper
 * @Time : 2019/2/2 21:44
 */
public class IsBanlancedTree {
    /**
     * 平衡二叉树:它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1,
     * 并且左右两个子树都是一棵平衡二叉树
     */
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
            return false;
        }
        //要判断子树是否平衡
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    /**
     * 树的深度函数
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
