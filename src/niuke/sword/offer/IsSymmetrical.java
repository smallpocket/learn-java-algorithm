package niuke.sword.offer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @Title : 对称的二叉树
 * @Author : Heper
 * @Time : 2019/2/5 13:20
 */
public class IsSymmetrical {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可，采用递归
     * 非递归也可，采用栈或队列存取各级子树根节点
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return ifSymmetrical(pRoot.left, pRoot.right);
    }

    boolean ifSymmetrical(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null) {
            return pRight == null;
        }
        if (pRight == null) {
            return false;
        }
        if (pLeft.val != pRight.val) {
            return false;
        }
        return ifSymmetrical(pLeft.left, pRight.right) && ifSymmetrical(pLeft.right, pRight.left);
    }
}
