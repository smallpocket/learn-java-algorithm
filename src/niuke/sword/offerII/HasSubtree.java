package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/9 21:59
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
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
            return (ifSub(root1.left, root2.left) && ifSub(root1.right, root2.right)) || ifSub(root1.left, root2) || ifSub(root1.right, root2);
        } else {
            return ifSub(root1.left, root2) || ifSub(root1.right, root2);
        }
    }
}
