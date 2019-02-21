package leetcode.top;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * @author Heper
 * @title x 的平方根
 * @date 2019/2/20 16:11
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1, high = x;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            //FIXME:防止溢出
            int sqrt = x / middle;
            //if(middle*middle<sqrt)
            if (middle < sqrt) {
                low = middle + 1;
            } else if (middle > sqrt) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return high;
    }
}
