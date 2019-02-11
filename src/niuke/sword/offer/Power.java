package niuke.sword.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author Heper
 * @title 数值的整数次方
 * @date 2019/2/10 23:19
 */
public class Power {
    /**
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        int e = Math.abs(exponent);
        double number = base;
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        for (int i = 1; i < e; i++) {
            number *= base;
        }
        //指数为负数
        if (exponent < 0) {
            number = 1 / number;
        }
        return number;
    }
}
