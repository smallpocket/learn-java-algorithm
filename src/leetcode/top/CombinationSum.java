package leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author Heper
 * @title 组合求和
 * @date 2019/2/17 16:36
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination,
                              List<List<Integer>> combinations,
                              int start,
                              int target,
                              int[] candidates) {
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
