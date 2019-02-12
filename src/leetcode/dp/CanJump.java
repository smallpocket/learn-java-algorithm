package leetcode.dp;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author Heper
 * @title 跳跃游戏
 * @date 2019/2/11 23:22
 */
public class CanJump {
    /**
     * 解法2:从后向前遍历,如果可以到达后面,则截断后面
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int can = nums[0];
        for (int i = 0; i < can + 1 && i < nums.length; i++) {
            if (nums[i] + i > can) {
                can = nums[i] + i;
            }
        }
        if (can >= nums.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        canJump(new int[]{1, 2, 3});
    }
}
