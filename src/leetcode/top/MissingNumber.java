package leetcode.top;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * @author Heper
 * @title 缺失数字
 * @date 2019/3/15 16:06
 */
public class MissingNumber {
    /**
     * 已经出现的数字将全部在异或当中抵消
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }
}
