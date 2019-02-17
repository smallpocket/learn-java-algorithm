package leetcode.top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的
 * 完全平方数的个数最少。
 * <p>
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * <p>
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 *
 * @author Heper
 * @title 完全平方数
 * @date 2019/2/17 13:27
 */
public class NumSquares {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     *
     * @return 1, 4, 9, ...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }


    /**
     * dp
     *
     * @param n 数字
     * @return
     */
//    public int numSquares(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        for (int i = 0; i * i <= n; ++i) {
//            dp[i * i] = 1;
//        }
//        for (int i = 1; i <= n; ++i) {
//            for (int j = 1; i + j * j <= n; ++j) {
//                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
//            }
//        }
//        return dp[n];
//    }
    public static void main(String[] args) {
        new NumSquares().numSquares(3);
    }
}
