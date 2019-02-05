package niuke.sword.offer;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @Title : 把二叉树打印成多行
 * @Author : Heper
 * @Time : 2019/2/5 16:40
 */
public class PrintFloorTree {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 神奇的递归解法
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    /**
     * 第一次的递归: 获取root的值,即第一层,下到第二层两个节点
     * 第二次:获取左结点的值,并下到第三层左结点当中
     * 第三次:最左侧的结点,加入了一个新的ArrayList当中
     *
     * @param root
     * @param depth
     * @param list
     */
    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        if (depth > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }

}
