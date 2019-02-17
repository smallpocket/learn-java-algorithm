package leetcode.top;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过
 * 水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 *
 * @author Heper
 * @title 岛屿的个数
 * @date 2019/2/17 15:14
 */
public class NumIslands {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * 基于深度优先,将所有搜索到的全部置换为0
     *
     * @param grid
     * @param nRow
     * @param nCol
     */
    public void dfs(char[][] grid, int nRow, int nCol) {
        if (nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length || grid[nRow][nCol] == '0') {
            return;
        }
        grid[nRow][nCol] = '0';
        for (int[] d : direction) {
            dfs(grid, nRow + d[0], nCol + d[1]);
        }
    }
}
