package leetcode.top;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合
 * 。你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * @author Heper
 * @title 岛屿的最大面积
 * @date 2019/2/17 15:05
 */
public class MaxAreaOfIsland {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 深度优先搜索
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int nRow, int nCol) {
        if (nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length || grid[nRow][nCol] == 0) {
            return 0;
        }
        grid[nRow][nCol] = 0;
        int maxArea = 1;
        for (int[] d : direction) {
            maxArea += dfs(grid, nRow + d[0], nCol + d[1]);
        }
        return maxArea;
    }
}


//    public int maxAreaOfIsland(int[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        m = grid.length;
//        n = grid[0].length;
//        int maxArea = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                maxArea = Math.max(maxArea, dfs(grid, i, j));
//            }
//        }
//        return maxArea;
//    }
//
//    private int dfs(int[][] grid, int r, int c) {
//        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
//            return 0;
//        }
//        grid[r][c] = 0;
//        int area = 1;
//        for (int[] d : direction) {
//            area += dfs(grid, r + d[0], c + d[1]);
//        }
//        return area;
//    }
//}
