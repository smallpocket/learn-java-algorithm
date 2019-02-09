package niuke.sword.offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为
 * 3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @Title : 机器人的运动范围
 * @Author : Heper
 * @Time : 2019/2/8 17:05
 */
public class MovingCount {

    /**
     * @param threshold 最大数字
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1 || threshold < 1) {
            return 0;
        }
        //默认值为false
        boolean[][] ifExist = new boolean[rows][cols];
        int curx = 0, cury = 0;
        //首先可以到达(0,0)
        return move(threshold, rows, cols, ifExist, curx, cury);
    }

    /**
     * @param threshold
     * @param rows
     * @param cols
     * @param curx      方格行数坐标
     * @param cury      方格列数坐标
     */
    public static int move(int threshold, int rows, int cols, boolean[][] ifExist, int curx, int cury) {
        //矩阵下标越界则退出,数字越界则退出
        if (curx < 0 || curx >= rows || cury < 0 || cury >= cols || ifMore(threshold, curx, cury) || ifExist[curx][cury]) {
            return 0;
        }
        //未经过的格子
        if (!ifExist[curx][cury]) {
            ifExist[curx][cury] = true;
        }
        //FIXME:这样会报错,因为curx+1与curx-1会无限循环!!!!!!
//        return move(threshold, rows, cols, ifExist, curx + 1, cury)
//                + move(threshold, rows, cols, ifExist, curx - 1, cury)
//                + move(threshold, rows, cols, ifExist, curx, cury + 1)
//                + move(threshold, rows, cols, ifExist, curx, cury - 1)
//                + 1;
        return move(threshold, rows, cols, ifExist, curx + 1, cury)
                + move(threshold, rows, cols, ifExist, curx, cury + 1)
                + move(threshold, rows, cols, ifExist, curx - 1, cury)
                + move(threshold, rows, cols, ifExist, curx, cury - 1)
                + 1;
    }

    public static boolean ifMore(int threshold, int curx, int cury) {
        int number = 0;
        while (curx != 0) {
            number += curx % 10;
            curx /= 10;
        }
        while (cury != 0) {
            number += cury % 10;
            cury /= 10;
        }
        if (number > threshold) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        movingCount(5, 5, 5);
    }
}
