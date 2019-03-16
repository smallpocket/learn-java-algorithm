package bytedis.exam.result;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/3/16 10:37
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();
        //注意while处理多个case
        for (int i = 0; i < testCase; i++) {
            int a = in.nextInt();
            int score[] = new int[a];
            for (int j = 0; j < a; j++) {
                score[j] = in.nextInt();
            }
            int res[] = new int[a];
            //先所有人分配一个奖品
            Arrays.fill(res, 1);
            int index = 0;
            int pre, last;
            boolean result = false;
            while (true) {
                if (index == 0) {
                    pre = a - 1;
                    last = index + 1;
                } else if (index == a - 1) {
                    pre = index - 1;
                    last = 0;
                } else {
                    pre = index - 1;
                    last = index + 1;
                }
                boolean temp = exchange(score, res, pre, index, last);
                if (temp != false) {
                    result = true;
                }
                if (index == a - 1) {
                    if (result == true) {
                        index = 0;
                        result = false;
                    } else {
                        break;
                    }
                } else {
                    index++;
                }
            }
            int liwu = 0;
            for (int j = 0; j < a; j++) {
                liwu += res[j];
            }
            System.out.println(liwu);
        }
    }

    public static boolean exchange(int[] score, int[] res, int pre, int index, int last) {
        boolean result = false;
        if (score[index] > score[last] && res[index] <= res[last]) {
            res[index] = res[last] + 1;
            result = true;
        }
        if (score[index] > score[pre] && res[index] <= res[pre]) {
            res[index] = res[pre] + 1;
            result = true;
        }
        return result;
    }
}
