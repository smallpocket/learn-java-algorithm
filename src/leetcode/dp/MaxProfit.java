package leetcode.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author Heper
 * @title 买卖股票的最佳时机
 * @date 2019/2/11 19:34
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxPrice = prices[prices.length - 1];
        int[] dp = new int[prices.length + 1];
        //从尾部开始，计算当前值到最后值这一段数字可以取得的最大收益。
        for (int i = prices.length - 1; i > -1; i--) {
            //最高价格
            if (prices[i] >= maxPrice) {
                maxPrice = prices[i];
                dp[i] = dp[i + 1];
            } else {
                //状态转移方程
                dp[i] = Math.max(dp[i + 1], maxPrice - prices[i]);
            }
        }
        return dp[0];
    }
}
