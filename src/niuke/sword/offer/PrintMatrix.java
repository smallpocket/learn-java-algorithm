package niuke.sword.offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @Title : 顺时针打印数组
 * @Author : Heper
 * @Time : 2019/2/4 21:34
 */
public class PrintMatrix {
    private boolean turnType = true;

    /**
     * 拧魔方思路法
     * TODO:没有解决
     * 123  -> 69
     * 456     58
     * 789     47
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length = matrix.length * matrix[0].length;
        if (matrix[0].length == 1) {
            turnType = false;
        }
        for (int haveNext = 1; haveNext == 1; ) {
            //二维数组，matrix.length是行数   matrix[0].length是列数
            for (int i = 0; i < matrix[0].length; i++) {
                arrayList.add(matrix[0][i]);
            }
            if (arrayList.size() == length) {
                return arrayList;
            }
            matrix = turn(matrix);
        }
        return arrayList;
    }

    /**
     * 魔方旋转
     *
     * @param matrix
     * @return
     */
    public int[][] turn(int[][] matrix) {
        int a, b;
        int i, j;
        int[][] newMatrix;
        if (turnType) {
            newMatrix = new int[matrix[0].length - 1][matrix.length];
            turnType = false;
            for (j = matrix[0].length - 1, a = 0; j > -1; j--, a++) {
                for (i = 1, b = 0; i < matrix.length; i++, b++) {
                    newMatrix[a][b] = matrix[i][j];
                }
            }
        } else {
            newMatrix = new int[matrix[0].length][matrix.length - 1];
            turnType = true;
            for (j = matrix[0].length - 1, b = 0; j > -1; j--, b++) {
                for (i = 1, a = 0; i < matrix.length; i++, a++) {
                    newMatrix[b][a] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }

    //FIXME:真正的解法
    public ArrayList<Integer> printMatrix2(int[][] array) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length == 0) {
            return result;
        }
        int n = array.length, m = array[0].length;
        if (m == 0) {
            return result;
        }
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) {
                result.add(array[i][k]);//左至右
            }
            for (int j = i + 1; j < n - i; j++) {
                result.add(array[j][m - i - 1]);//右上至右下
            }
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) {
                result.add(array[n - i - 1][k]);//右至左
            }
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) {
                result.add(array[j][i]);//左下至左上
            }
        }
        return result;
    }

}
