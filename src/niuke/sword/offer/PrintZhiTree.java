package niuke.sword.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @Title : 按之字形顺序打印二叉树
 * @Author : Heper
 * @Time : 2019/2/5 14:49
 */
public class PrintZhiTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 用一个栈保存每一行的数据
     *
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        //奇数
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        //是否是奇数层
        boolean ifOdd = true;
        odd.push(pRoot);
        TreeNode temp;
        //两个栈非空
        while (!odd.empty() || !even.empty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            //如果是奇数层
            if (ifOdd) {
                while (!odd.empty()) {
                    temp = odd.pop();
                    if (temp != null) {
                        arrayList.add(temp.val);
                        //先左后右
                        even.push(temp.left);
                        even.push(temp.right);
                    }
                }
                ifOdd = !ifOdd;
            } else {
                while (!even.empty()) {
                    temp = even.pop();
                    if (temp != null) {
                        arrayList.add(temp.val);
                        //先右后左
                        odd.push(temp.right);
                        odd.push(temp.left);
                    }
                }
                ifOdd = !ifOdd;
            }
            if (arrayList.size() != 0) {
                list.add(arrayList);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        treeNode.left = left;
        treeNode.right = right;
        Print(treeNode);
    }
}
