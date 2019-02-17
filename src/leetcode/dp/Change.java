package leetcode.dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 3[2]=111 12
 * 4[3]=1111 112 22
 * 6[5]=11111 222 2211 21111 51
 * 7[6] 1111111 2221 22111 21111 52 511
 * <p>
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * <p>
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * 注意:
 * 你可以假设：
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * @author Heper
 * @title 零钱兑换ii
 * @date 2019/2/12 17:32
 */
public class Change {
    public static int change(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        /**
         * FIXME:不能先钱后硬币
         * 必须先硬币后钱
         * for (int j = 1; j <= amount; j++) {
         * for (int i : coins) {
         */
        for (int i : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j == i) {
                    dp[j]++;
                } else if (j > i) {
                    dp[j] += dp[j - i];
                }
            }
        }
        return dp[amount];
    }

    /**
     * 简洁写法
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int a[] = new int[amount + 1];
        Arrays.fill(a, 0);
        a[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    a[j] = a[j] + a[j - coins[i]];
                }
            }
        }
        return a[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(new int[]{1, 2, 5}, 1));
        System.out.println(change(new int[]{1, 2, 5}, 2));
        System.out.println(change(new int[]{1, 2, 5}, 3));
        System.out.println(change(new int[]{1, 2, 5}, 4));
        System.out.println(change(new int[]{1, 2, 5}, 5));
    }
}
