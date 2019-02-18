package leetcode.top;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 * <p>
 * 注意:
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 *
 * @author Heper
 * @title 目标和
 * @date 2019/2/18 13:51
 */
public class FindTargetSumWays {
    /**
     * 0-1背包
     */
//    public int findTargetSumWays(int[] nums, int S) {
//        int sum = computeArraySum(nums);
//        if (sum < S || (sum + S) % 2 == 1) {
//            return 0;
//        }
//        int W = (sum + S) / 2;
//        int[] dp = new int[W + 1];
//        dp[0] = 1;
//        for (int num : nums) {
//            for (int i = W; i >= num; i--) {
//                dp[i] = dp[i] + dp[i - num];
//            }
//        }
//        return dp[W];
//    }
//
//    private int computeArraySum(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        return sum;
//    }

    /**
     * dfs求解
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S);
    }

    public int dfs(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return dfs(nums, start + 1, S - nums[start])
                + dfs(nums, start + 1, S + nums[start]);
    }
}
