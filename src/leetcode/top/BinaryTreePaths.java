package leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @author Heper
 * @title 二叉树的所有路径
 * @date 2019/2/17 15:37
 */
public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values);
        return result;
    }

    /**
     * 回溯法求解
     *
     * @param root
     * @param values
     */
    public void backtracking(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(buildPath(values));
        } else {
            backtracking(root.left, values);
            backtracking(root.right, values);
        }
        values.remove(values.size() - 1);

    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
