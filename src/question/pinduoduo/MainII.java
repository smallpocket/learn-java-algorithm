package question.pinduoduo;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/5/6 19:20
 */
public class MainII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //人口
        int people = in.nextInt();
        //方言数量
        int num = in.nextInt();
        //说每种方言的人数
        int[] nums = new int[num];
        int total = 0;
        for (int i = 0; i < num; i++) {
            nums[i] = in.nextInt();
            total += nums[i];
        }
        int res = total - people * (num - 1);
        if (res < 0) {
            res = 0;
        }
        System.out.println(res);
    }
}
