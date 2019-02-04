package niuke.sword;

import niuke.sword.offer.PrintMatrix;

/**
 * @Author : Heper
 * @Time : 2019/2/4 22:24
 */
public class Test {
    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();

        printMatrix.printMatrix(new int[][]{{1}, {2}, {3}, {4}, {5}});
    }
}
