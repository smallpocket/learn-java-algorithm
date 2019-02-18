package leetcode.top;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author Heper
 * @title 翻转二叉树
 * @date 2019/2/18 17:32
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
