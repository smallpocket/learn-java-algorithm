package niuke.sword.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入
 * 这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含
 * "abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @Title :矩阵中的路径
 * @Author : Heper
 * @Time : 2019/2/8 17:04
 */
public class HasPath {
    /**
     * @param matrix 字符串矩阵
     * @param rows   行数
     * @param cols   列数
     * @param str    需要的字符串
     * @return 是否存在
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }
        //判断是否已经访问过
        boolean[] ifExist = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isHsaPath(matrix, rows, cols, str, 0, ifExist, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param matrix  字符串矩阵
     * @param rows    行数
     * @param cols    列数
     * @param str     需要的字符串
     * @param ifExist 是否经过格子的判断矩阵
     * @param curx    应该是访问到的矩阵横坐标
     * @param cury    应该是访问到的矩阵纵坐标
     * @return
     */
    public boolean isHsaPath(char[] matrix, int rows, int cols, char[] str, int pos, boolean[] ifExist, int curx, int cury) {
        if (pos == str.length) {
            return true;
        }
        //判断是否越界
        if (curx < 0 || curx >= rows || cury < 0 || cury >= cols) {
            return false;
        }
        //判断是否访问过该位置,以及字符是否匹配
        if (ifExist[curx * cols + cury] || str[pos] != matrix[curx * cols + cury]) {
            return false;
        }
        //在该位置处,该节点被访问过
        ifExist[curx * cols + cury] = true;
        boolean result = isHsaPath(matrix, rows, cols, str, pos + 1, ifExist, curx + 1, cury)
                || isHsaPath(matrix, rows, cols, str, pos + 1, ifExist, curx - 1, cury)
                || isHsaPath(matrix, rows, cols, str, pos + 1, ifExist, curx, cury + 1)
                || isHsaPath(matrix, rows, cols, str, pos + 1, ifExist, curx, cury - 1);
        //推出递归,这个节点就相当于还没有被访问过
        ifExist[curx * cols + cury] = false;
        return result;
    }
}
