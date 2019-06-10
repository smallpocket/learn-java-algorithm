package question.sanliuliu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/24 19:25
 */
public class MainI {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int main() {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        //存放到map当中
        for (int i = 0; i < total; i++) {
            int ball = scanner.nextInt();
            if (!map.containsKey(ball)) {
                map.put(ball, 1);
            } else {
                map.put(ball, map.get(ball) + 1);
            }
        }
        //存放各种球出现的次数
        int[] nums = new int[map.keySet().size()];
        //索引
        int index = 0;
        //球出现的最少的次数
        int minCount = 10000;
        for (int key : map.keySet()) {
            nums[index] = map.get(key);
            if (nums[index] < minCount) {
                minCount = nums[index];
            }
            index++;
        }
        //一个篮子当中放置的球数目
        int max = 1;
        for (int i = 1; i <= minCount; i++) {
            boolean res = true;
            for (int num : nums) {
                if (num % i != 0) {
                    res = false;
                    break;
                }
            }
            if (res == true && i > max) {
                max = i;
            }
        }
        if (max == 1) {
            return 0;
        } else {
            return total / max;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        res = main();
        System.out.println(String.valueOf(res));

    }
}
