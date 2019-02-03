package question;

import java.util.Scanner;

/**
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 * @Author : Heper
 * @Time : 2019/1/4 14:10
 */
public class MaxScore {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            //第一行数据,记录数目与操作数目
            String firstLine = scanner.nextLine();
            String[] firstStr = firstLine.split(" ");
            //第二行数据
            String secondLine = scanner.nextLine();
            String[] secondStr = secondLine.split(" ");
            //存放成绩
            int[] score = new int[Integer.parseInt(firstStr[0])];
            int max, floor, top;
            for (int i = 0; i < secondStr.length; i++) {
                score[i] = Integer.parseInt(secondStr[i]);
            }
            for (int j = 0; j < Integer.parseInt(firstStr[1]); j++) {
                String nextLine = scanner.nextLine();
                String[] numStr = nextLine.split(" ");
                if (numStr[0].equals("Q")) {
                    floor = Integer.parseInt(numStr[1]);
                    top = Integer.parseInt(numStr[2]);
                    if (top < floor) {
                        int temp = floor;
                        floor = top;
                        top = temp;
                    }
                    max = score[floor - 1];
                    for (int i = floor; i < top; i++) {
                        if (score[i] > max) {
                            max = score[i];
                        }
                    }
                    System.out.println(max);
                } else {
                    score[Integer.parseInt(numStr[1]) - 1] = Integer.parseInt(numStr[2]);
                }
            }
        }
    }
}
