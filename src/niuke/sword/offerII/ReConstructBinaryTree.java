package niuke.sword.offerII;


/**
 * @author Heper
 * @title
 * @date 2019/3/8 20:17
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

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
