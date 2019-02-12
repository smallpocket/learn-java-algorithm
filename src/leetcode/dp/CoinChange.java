package leetcode.dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author Heper
 * @title 零钱兑换
 * @date 2019/2/12 17:31
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] type = new int[amount + 1];
        //填充数组,以amount+1填充
        //FIXME:对数组操作的一个类,也可以进行排序
        Arrays.fill(type, amount + 1);
        type[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                //即货币面值小于金额
                if (coins[j] <= i) {
                    type[i] = Math.min(type[i - coins[j]] + 1, type[i]);
                }
            }
        }
        return type[amount] == amount + 1 ? -1 : type[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange()
                .coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange()
                .coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
