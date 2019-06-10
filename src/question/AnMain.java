package question;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/10 10:44
 */
public class AnMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] price = new int[num];
        for (int i = 0; i < num; i++) {
            price[i] = scanner.nextInt();
        }
        int[] res = MaxProfit.maxProfit(price);
        System.out.println(res[0] + " " + res[1]);
    }
}

class MaxProfit {

    public static int[] maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        int num = 0;
        while (i < prices.length - 1) {
            //价格在上涨,跳过
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            //出现一个高峰
            valley = prices[i];
            num++;
            //找到连续的最高峰
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            //卖出
            maxprofit += peak - valley;
            num++;
        }
        if (maxprofit == 0) {
            num = 0;
        }
        return new int[]{maxprofit, num};
    }
}