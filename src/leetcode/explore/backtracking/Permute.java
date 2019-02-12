package leetcode.explore.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author Heper
 * @title 全排列
 * @date 2019/2/11 22:51
 */
public class Permute {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        add(0, nums);
        return lists;
    }

    /**
     * @param index 加入的数字索引
     * @param nums
     */
    public void add(int index, int[] nums) {
        if (index == nums.length) {
            lists.add(set(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //更改数组的排列!!,做一个克隆
            int[] nums_temp = nums.clone();
            swap(nums_temp, index, i);
            add(index + 1, nums_temp);
        }
    }

    /**
     * 将数组转换为一个list
     *
     * @param nums
     * @return
     */
    public List<Integer> set(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    /**
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
