package leetcode.dp;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author Heper
 * @title
 * @date 2019/2/13 16:16
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        //dp记录对应row,每个位置结点的最小路径
        int[] dp = new int[triangle.size()];
        //记录当前行号
        int row;
        //从下向上加
        for (row = triangle.size() - 1; row > 0; row--) {
            //获取对应行号的list
            List<Integer> list = triangle.get(row);
            List<Integer> preList = triangle.get(row - 1);
            for (int j = 0; j < preList.size(); j++) {
                //要用set改变值
                //get获得的是对象,不是value
                preList.set(j, preList.get(j) + Math.min(list.get(j), list.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
