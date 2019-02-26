package leetcode.top;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * @author Heper
 * @title 路径总和 III
 * @date 2019/2/26 17:38
 */
public class PathSumIII {

    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //因为必须是连续的,所以需要这样写
        pathSumStartWithRoot(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void pathSumStartWithRoot(TreeNode root, int sum) {

        if (root == null) {
            return;
        }
        if (sum - root.val == 0) {
            res++;
        }
        pathSumStartWithRoot(root.left, sum - root.val);
        pathSumStartWithRoot(root.right, sum - root.val);
    }
}
