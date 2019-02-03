package sword.offer;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @Author : Heper
 * @Time : 2019/2/2 21:36
 */
public class TreeDepth {

    /**
     * 内部类,树的结点
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
     * 使用递归,还是遗忘了太多了
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int nLeft = TreeDepth(root.left);
            int nRight = TreeDepth(root.right);
            return nLeft > nRight ? (nLeft + 1) : (nRight + 1);
        }

    }
}
