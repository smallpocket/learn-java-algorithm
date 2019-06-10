package question.meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/23 19:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        //存放矩阵的值
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //找到矩阵当中，斜方向上出现次数最多与次多的数字。并且一共多少个数
        int[][] res = new int[2][5];
        Arrays.fill(res[0], 0);
        Arrays.fill(res[1], 0);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < row; i++) {
            int numberCount = 0;
            if (i % 2 == 0) {
                for (int j = 0; j < col; j = j + 2) {
                    if (!count.containsKey(matrix[i][j])) {
                        count.put(matrix[i][j], 1);
                    } else {
                        numberCount = count.get(matrix[i][j]) + 1;
                        count.put(matrix[i][j], numberCount);
                    }
                }
            } else {
                for (int j = 1; j < col; j = j + 2) {
                    if (!count.containsKey(matrix[i][j])) {
                        count.put(matrix[i][j], 1);
                    } else {
                        count.putIfAbsent(matrix[i][j], 1);
                        numberCount = count.get(matrix[i][j]) + 1;
                        count.put(matrix[i][j], numberCount);
                    }
                }
            }
        }

        findMax(count, res, 0);

        count.clear();
        for (int i = 0; i < row; i++) {
            int numberCount = 0;
            if (i % 2 == 0) {
                for (int j = 1; j < col; j = j + 2) {
                    if (!count.containsKey(matrix[i][j])) {
                        count.put(matrix[i][j], 1);
                    } else {
                        count.putIfAbsent(matrix[i][j], 1);
                        numberCount = count.get(matrix[i][j]) + 1;
                        count.put(matrix[i][j], numberCount);
                    }
                }
            } else {
                for (int j = 0; j < col; j = j + 2) {
                    if (!count.containsKey(matrix[i][j])) {
                        count.put(matrix[i][j], 1);
                    } else {
                        count.putIfAbsent(matrix[i][j], 1);
                        numberCount = count.get(matrix[i][j]) + 1;
                        count.put(matrix[i][j], numberCount);
                    }
                }
            }
        }
        findMax(count, res, 1);


        if (res[0][0] != res[1][0]) {
            System.out.println(res[0][4] + res[1][4] - res[0][1] - res[1][1]);
        } else {
            if (res[0][1] + res[1][3] > res[0][3] + res[1][1]) {
                System.out.println(res[0][3] + res[1][1]);
            } else {
                System.out.println(res[0][1] + res[1][3]);
            }
        }
    }

    public static void findMax(Map<Integer, Integer> count, int[][] res, int row) {
        for (int key : count.keySet()) {
            int value = count.get(key);
            //大于次大数
            if (value > res[row][3] && key != res[row][2]) {
                //大于最大数
                if (value > res[row][1] && key != res[row][0]) {
                    if (res[row][2] != res[row][0]) {
                        res[row][2] = res[row][0];
                        res[row][3] = res[row][1];
                    }
                    res[row][0] = key;
                    res[row][1] = value;
                } else {
                    res[row][3] = value;
                    res[row][2] = key;
                }
            }
            //共多少数字
            res[row][4] += value;
        }
    }
}
