package leetcode.dp;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * <p>
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * @author Heper
 * @title 比特位计数
 * @date 2019/2/11 21:34
 */
public class CountBits {
    public static int[] countBits(int num) {
        int[] oneNum = new int[num + 1];
        if (num == 0) {
            oneNum[0] = 0;
            return oneNum;
        }
        //换作Log2 num
        int count = (int) (Math.log(num) / Math.log(2));
        int base, k;
        //依靠 1 2 4 8将结果分行
        for (int i = 0; i <= count; i++) {
            //+1去掉oneNum[0]
            base = (int) Math.pow(2, i);
            k = 0;
            for (int j = base; j < Math.pow(2, i + 1) && j < num + 1; j++, k++) {
                if (j == base) {
                    oneNum[j] = 1;
                } else {
                    oneNum[j] = oneNum[base] + oneNum[k];
                }
            }
        }
        return oneNum;
    }

    /**
     * 最快的解法
     *
     * @param args
     */
//    public int[] countBits(int num) {
//        int[] barr = new int[num + 1];
//        barr[0] = 0;
//        for (int i = 1; i <= num; i++) {
//            barr[i] =  barr[i >> 1] +(i & 1);
//        }
//        return barr;
//    }
    public static void main(String[] args) {
        countBits(8);
    }
}
