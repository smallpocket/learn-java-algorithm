package leetcode.top;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 *
 * @author Heper
 * @title 计算在网格中从原点到特定点的最短路径长度
 * @date 2019/2/17 13:29
 */
public class MinPathLength {
    /**
     * 最短的路径一定是广度优先
     * 因为在广度优先当中,在每一次迭代中,走的步数只走一步,即探索在最短步伐走最多的路
     * 这个做法是用循环的,递归可能简单一些
     *
     * @param grids
     * @param tr
     * @param tc
     * @return
     */
    public int minPathLength(int[][] grids, int tr, int tc) {
        int row = grids.length;
        int col = grids[0].length;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        //走过的路径队列
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        //初始点
        queue.add(new Pair<>(0, 0));
        //广度走到的路径深度
        int depth = 0;
        //如果队列不空
        while (!queue.isEmpty()) {
            //队列当中的元素数目
            int size = queue.size();
            depth++;
            //使用size只出队当前一个深度的数量
            while (size-- > 0) {
                //出队一个元素
                Pair<Integer, Integer> pair = queue.poll();
                int nodeRow = pair.getKey();
                int nodeCol = pair.getValue();
                // 标记,该节点已经走过了,更新为0
                grids[nodeRow][nodeCol] = 0;
                for (int[] d : dir) {
                    int nr = nodeRow + d[0];
                    int nc = nodeCol + d[1];
                    if (nr < 0 || nc < 0 || nr >= row || nc >= col || grids[nr][nc] == 0) {
                        continue;
                    }
                    if (nr == tr && nr == tc) {
                        return depth;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }


//    public int minPathLength(int[][] grids, int tr, int tc) {
//        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        int m = grids.length;
//        int n = grids[0].length;
//        //走过的路径队列
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        //初始点
//        queue.add(new Pair<>(0, 0));
//        //广度走到的路径深度
//        int pathLength = 0;
//        //先进先出,维持广度搜索
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            pathLength++;
//            while (size-- > 0) {
//                //出队一个元素
//                Pair<Integer, Integer> cur = queue.poll();
//                int cr = cur.getKey(), cc = cur.getValue();
//                // 标记,该节点已经走过了,更新为0
//                grids[cr][cc] = 0;
//                for (int[] d : direction) {
//                    int nr = cr + d[0], nc = cc + d[1];
//                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0) {
//                        continue;
//                    }
//                    if (nr == tr && nc == tc) {
//                        return pathLength;
//                    }
//                    queue.add(new Pair<>(nr, nc));
//                }
//            }
//        }
//        return -1;
//    }
}
