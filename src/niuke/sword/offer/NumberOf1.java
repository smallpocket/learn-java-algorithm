package niuke.sword.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author Heper
 * @title 二进制中1的个数
 * @date 2019/2/10 23:18
 */
public class NumberOf1 {
    /**
     * Fixme:补码是啥来着
     * 反码:对除符号位(最高位0为正,1为负)外的其余各位逐位取反
     * 负数的补码:反码+1
     * 正数的补码:==反码
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        //位运算,将其每一位与1进行&运算
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
