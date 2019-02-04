package niuke.sword.offer;

/**
 * 镜像二叉树
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @Author : Heper
 * @Time : 2019/2/4 21:30
 */
public class Mirror {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 一个简答的递归即可
     *
     * @param root
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            mirror(root.left);
            mirror(root.right);
        }
    }
}
