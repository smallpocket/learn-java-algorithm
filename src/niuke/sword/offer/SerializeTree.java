package niuke.sword.offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @Title : 序列化二叉树
 * @Author : Heper
 * @Time : 2019/2/5 18:15
 */
public class SerializeTree {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 标记字符索引
     */
    private int index = -1;

    /**
     * 序列化二叉树:即将一颗二叉树转变为一个字符串
     * 遍历所有结点,并且如果结点有空结点,则记作#
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    /**
     * 依据序列化的字符串创建二叉树
     *
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        index++;
        //依据,对字符串进行分割
        String[] strr = str.split(",");
        //达到字符串末尾
        if (index * 2 > str.length()) {
            return null;
        }
        TreeNode treeNode = null;
        if (!strr[index].equals("#")) {
            treeNode = new TreeNode(Integer.valueOf(strr[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }
}
