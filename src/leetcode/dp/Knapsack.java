package leetcode.dp;

/**
 * 有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
 * 定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达
 * 到的最大价值。设第 i 件物品体积为 w，价值为 v，根据第 i 件物品是否添加到背包中，可以分两种情况讨论：
 * <p>
 * 第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1
 * 件物品的最大价值，dp[i][j] = dp[i-1][j]。
 * 第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v。
 * 第 i 件物品可添加也可以不添加，取决于哪种情况下最大价值更大。因此，0-1 背包的状态转移方程为：
 *
 * @author Heper
 * @title 0-1 背包
 * @date 2019/2/22 15:40
 */
public class Knapsack {
    /**
     * @param W       最大体积
     * @param N       容量
     * @param weights 物品体积数组
     * @param values  物品价值数组
     * @return
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        //从放1件物品到放N件物品
        for (int i = 1; i <= N; i++) {
            int weight = weights[i - 1], value = values[i - 1];
            //背包的可容纳体积从1涨到上限W
            for (int j = 1; j <= W; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 空间优化
     * <p>
     * 在程序实现时可以对 0-1 背包做优化。观察状态转移方程可以知道，前 i 件物品的状态仅与前 i-1
     * 件物品的状态有关，因此可以将 dp 定义为一维数组，其中 dp[j] 既可以表示 dp[i-1][j] 也可以
     * 表示 dp[i][j]。此时，
     * dp[j]=max(dp[j],dp[j-w]+v)
     * 因为 dp[j-w] 表示 dp[i-1][j-w]，因此不能先求 dp[i][j-w]，以防将 dp[i-1][j-w] 覆盖。
     * 也就是说要先计算 dp[i][j] 再计算 dp[i][j-w]，在程序实现时需要按倒序来循环求解。
     *
     * @param W       最大体积
     * @param N       容量
     * @param weights 物品体积数组
     * @param values  物品价值数组
     * @return
     */
    public int knapsackII(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int weight = weights[i - 1], value = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= weight) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + value);
                }
            }
        }
        return dp[W];
    }
}
