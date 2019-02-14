package niuke.sword.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点
 * 开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author Heper
 * @title 二叉树中和为某一值的路径
 * @date 2019/2/14 18:12
 */
public class FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    /**
     * ArrayList的复制是什么来着
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, target);
        return result;
    }

    /**
     * 因为要求是到达叶子结点的路径,所以left与right要为null
     *
     * @param treeNode
     * @param target
     */
    public void dfs(TreeNode treeNode, int target) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        target -= treeNode.val;
        if (target == 0 && treeNode.left == null && treeNode.right == null) {
            //FIXME:开辟一个新ArrayList的方法
            result.add(new ArrayList<>(list));
        }
        dfs(treeNode.left, target);
        dfs(treeNode.right, target);
        list.remove(list.size() - 1);
    }
}
