package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/8 19:50
 */
public class Find {
    public boolean find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (target < array[i][j]) {
                i--;
            } else if (target > array[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
