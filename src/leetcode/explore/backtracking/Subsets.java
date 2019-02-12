package leetcode.explore.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author Heper
 * @title 子集
 * @date 2019/2/11 22:51
 */
public class Subsets {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return ret;
    }

    void dfs(List<Integer> list, int[] nums, int i) {
        if (i == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            //使用j+1,避免出现重复
            dfs(list, nums, j + 1);
            list.remove(list.size() - 1);
        }
        dfs(list, nums, nums.length);
    }
    /**
     * TODO:解法2:遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     */
}
