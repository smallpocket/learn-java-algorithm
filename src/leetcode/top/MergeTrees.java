package leetcode.top;

/**
 * 定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值
 * ，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * @author Heper
 * @title 合并二叉树
 * @date 2019/2/18 17:35
 */
public class MergeTrees {
    /**
     * 学习代码的写法
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
