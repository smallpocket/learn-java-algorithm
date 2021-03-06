package niuke.sword.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中
 * 都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @Title : 重建二叉树
 * @Author : Heper
 * @Time : 2019/2/10 13:15
 */
public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @param pre 前序
     * @param in  中序
     * @return 返回根节点吧
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 每颗子树的根节点肯定是pre子数组的首元素，所以每次新建一个子树的根节点
     * 递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，前序的开始结束索引通过计算中序
     * 中左右子树的大小来计算，然后递归求解，直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回
     * 左子树活右子树的根节点
     *
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //FIXME:将每一个结点当成一颗新树做递归
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            //前序的都是根节点
            if (in[i] == pre[startPre]) {
                //将左右节点当成一颗子树
                //startPre+1,前序的先左后右,则说明对于前序,下一个便是左子树的根节点
                //startPre+i-startIn,以这个结束,原因是,如果对这个节点做前序遍历,那么最后的结点是这个
                //i-1:如果对这个结点做中序,末尾结点位置为i-1
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //i - startIn + startPre + 1:
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }

        return root;
    }
}
