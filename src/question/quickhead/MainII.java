package question.quickhead;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/13 15:29
 */
public class MainII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long sum = 1;
        long last = 999999999;
        for (int i = 1; i <= num; i++) {
            sum *= i;
            while (sum % 10 == 0) {
                sum /= 10;
            }
            sum = sum % 1000000000;
        }
        System.out.println(sum % 10);

    }
}
