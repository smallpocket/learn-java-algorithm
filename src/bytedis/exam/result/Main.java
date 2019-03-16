package bytedis.exam.result;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/3/16 9:48
 */
public class Main {
    public static void main(String[] args) {
        int[] dp = new int[1024];
        int[] count = new int[4];
        count[0] = 1;
        count[1] = 4;
        count[2] = 16;
        count[3] = 64;
        Arrays.fill(dp, 1024);
        dp[0] = 0;
        for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < count.length; j++) {
                if (i < count[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - count[j]] + 1);
            }
        }
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int b = in.nextInt();
            System.out.println(dp[1024 - b]);
        }
    }
}
