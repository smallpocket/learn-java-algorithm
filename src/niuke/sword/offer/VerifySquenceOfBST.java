package niuke.sword.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,
 * 否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author Heper
 * @title 二叉搜索树的后序遍历序列
 * @date 2019/2/14 17:28
 */
public class VerifySquenceOfBST {
    /**
     * //TODO:
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
     * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序
     * 序列。完美的递归定义 : ) 。
     *
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return ifBst(sequence, 0, sequence.length - 1);
    }

    public boolean ifBst(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = end;
        while (i > start && sequence[i - 1] > sequence[end]) {
            --i;
        }
        for (int j = i - 1; j >= start; j--) {
            if (sequence[j] > sequence[end]) {
                return false;
            }
        }
        return ifBst(sequence, start, i - 1) && ifBst(sequence, i, end - 1);
    }
}
