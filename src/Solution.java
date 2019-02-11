package leetcode.dp;

/**
 * @author Heper
 * @title
 * @date 2019/2/11 19:39
 */
class Solution {
//    public:
//
//    int maxProfit(vector<int> &prices) {
//        unsigned n = prices.size();
//        if (n == 0) {
//            return 0;
//        }
//        //计算当前值到最后值这一段数字可以取得的最大收益。
//        vector<int> dp (n + 1, 0)
//        int max_p = prices[n - 1];
//        for (int i = n - 1; i >= 0; --i) {
//            if (prices[i] >= max_p) {
//                max_p = prices[i];
//                dp[i] = dp[i + 1];
//            } else {
//                dp[i] = max(dp[i + 1], max_p - prices[i]);
//            }
//        }
//        return dp[0];
//    }
}
