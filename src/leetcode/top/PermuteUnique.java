package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @author Heper
 * @title 全排列 II
 * @date 2019/2/17 16:13
 */
public class PermuteUnique {
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 排列问题,使用boolean数组进行筛选
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> values = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtacking(values, nums, visited);
        return result;
    }

    public void backtacking(List<Integer> values,
                            int[] nums,
                            boolean[] visited) {
        if (values.size() == nums.length) {
            result.add(new ArrayList<>(values));
        }
        for (int i = 0; i < visited.length; i++) {
            //FIXME:去重复
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            values.add(nums[i]);
            backtacking(values, nums, visited);
            values.remove(values.size() - 1);
            visited[i] = false;
        }
    }
}
