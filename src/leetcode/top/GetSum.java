package leetcode.top;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * @author Heper
 * @title 两整数之和
 * @date 2019/3/15 16:56
 */
public class GetSum {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
}
