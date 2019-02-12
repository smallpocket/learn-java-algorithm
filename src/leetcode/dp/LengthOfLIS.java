package leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * @author Heper
 * @title 最长上升子序列
 * @date 2019/2/12 17:52
 */
public class LengthOfLIS {
    /**
     * O(N^2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] len = new int[nums.length];
        int max = 1;
        Arrays.fill(len, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    len[i] = Math.max(len[j] + 1, len[i]);
                    if (max < len[i]) {
                        max = len[i];
                    }
                }
            }
        }
        return max;
    }
    /**
     dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     数组尾部, 并将最长递增序列长度maxL加1
     2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     **/
//    public int lengthOfLIS(int[] nums) {

//        int maxL = 0;
//        int[] dp = new int[nums.length];
//        for(int num : nums) {
//            // 二分法查找, 也可以调用库函数如binary_search
//            int lo = 0, hi = maxL;
//            while(lo < hi) {
//                int mid = lo+(hi-lo)/2;
//                if(dp[mid] < num)
//                    lo = mid+1;
//                else
//                    hi = mid;
//            }
//            dp[lo] = num;
//            if(lo == maxL)
//                maxL++;
//        }
//        return maxL;
//    }
}
