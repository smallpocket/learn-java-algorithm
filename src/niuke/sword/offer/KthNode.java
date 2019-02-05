package niuke.sword.offer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * @Title : 二叉搜索树的第k个结点
 * @Author : Heper
 * @Time : 2019/2/5 19:07
 */
public class KthNode {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private int index = 0;

    /**
     * 定义:也称为二叉搜索树、有序二叉树（ordered binary tree）或排序二叉树
     * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * 任意节点的左、右子树也分别为二叉查找树；
     * 没有键值相等的节点。
     *
     * @param pRoot
     * @param k
     * @return
     */

    TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        //要传递一个数组,不能是对象!!!
        TreeNode[] Result = new TreeNode[1];
        mid(pRoot, k, Result);
        return Result[0];
    }

    /**
     * 中序遍历得到的就是排序的结果,因此与中序遍历的顺序相符合即可
     *
     * @param pRoot
     * @param k
     * @param result
     */
    void mid(TreeNode pRoot, int k, TreeNode[] result) {
        if (pRoot == null) {
            return;
        }
        mid(pRoot.left, k, result);
        index++;
        if (index == k) {
            result[0] = pRoot;
        }
        mid(pRoot.right, k, result);
    }
}
