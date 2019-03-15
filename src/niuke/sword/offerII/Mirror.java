package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/9 22:03
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
