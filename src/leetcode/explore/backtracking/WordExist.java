package leetcode.explore.backtracking;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * @author Heper
 * @title 单词搜索
 * @date 2019/2/11 22:52
 */
public class WordExist {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        int row = board.length, col = board[0].length;
        boolean[][] ifExist = new boolean[row][col];
        char[] words = word.toCharArray();
        //FIXME:寻找首节点的方法
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, words, 0, ifExist)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 用于深度搜索,不能用于确定首节点
     *
     * @param board
     * @param rowIndex
     * @param colIndex
     * @param words
     * @param wordIndex
     * @param ifExist   判断是否访问过该节点
     * @return
     */
    public static boolean dfs(char[][] board,
                              int rowIndex,
                              int colIndex,
                              char[] words,
                              int wordIndex,
                              boolean[][] ifExist) {
        int row = board.length, col = board[0].length;
        boolean result = false;
        if (wordIndex == words.length) {
            return true;
        }
        if (rowIndex >= row
                || colIndex >= col
                || rowIndex < 0
                || colIndex < 0
                || ifExist[rowIndex][colIndex]) {
            return false;
        }
        if (board[rowIndex][colIndex] == words[wordIndex]) {
            ifExist[rowIndex][colIndex] = true;
            result = dfs(board, rowIndex + 1, colIndex, words, wordIndex + 1, ifExist)
                    || dfs(board, rowIndex, colIndex + 1, words, wordIndex + 1, ifExist)
                    || dfs(board, rowIndex - 1, colIndex, words, wordIndex + 1, ifExist)
                    || dfs(board, rowIndex, colIndex - 1, words, wordIndex + 1, ifExist);
            ifExist[rowIndex][colIndex] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        //char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = new char[][]{{'a', 'b'}};
        String word = "ba";
        exist(board, word);
    }
}
