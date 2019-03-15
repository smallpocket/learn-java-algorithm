package leetcode.top;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @author Heper
 * @title 汉明距离
 * @date 2019/3/15 15:53
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int num = 0;
        while (z != 0) {
            z = z & z - 1;
            num++;
        }
        return num;
    }
}
