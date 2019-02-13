package niuke.sword.offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author Heper
 * @title 树的子结构
 * @date 2019/2/13 19:39
 */
public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return ifSub(root1, root2);
    }

    public boolean ifSub(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return (ifSub(root1.left, root2.left) && ifSub(root1.right, root2.right)) || (ifSub(root1.left, root2) || ifSub(root1.right, root2));
        } else {
            return ifSub(root1.left, root2) || ifSub(root1.right, root2);
        }
    }
}
