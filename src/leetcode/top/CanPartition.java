package leetcode.top;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author Heper
 * @title 分割等和子集
 * @date 2019/2/18 13:34
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        for (int num : nums) {
            //从后向前
            for (int j = w; j >= num; j--) {
                dp[j] = dp[j] || dp[num - j];
            }
        }
        return dp[w];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
//    public boolean canPartition(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//        int sum = computeArraySum(nums);
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int W = sum / 2;
//        boolean[] dp = new boolean[W + 1];
//        dp[0] = true;
//        for (int num : nums) {                 // 0-1 背包一个物品只能用一次
//            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
//                dp[i] = dp[i] || dp[i - num];
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
}
