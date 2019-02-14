package niuke.sword.offer;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author Heper
 * @title 从上往下打印二叉树
 * @date 2019/2/14 17:23
 */
public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        printFloor(treeNodes);
        return result;
    }

    public void printFloor(ArrayList<TreeNode> treeNodes) {
        ArrayList<TreeNode> nextFloor = new ArrayList<>();
        for (TreeNode node : treeNodes) {
            result.add(node.val);
            if (node.left != null) {
                nextFloor.add(node.left);
            }
            if (node.right != null) {
                nextFloor.add(node.right);
            }
        }
        if (nextFloor.size() != 0) {
            printFloor(nextFloor);
        }
    }
}
