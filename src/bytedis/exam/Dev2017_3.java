package bytedis.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给出 n 个字符串，对于每个 n 个排列 p，按排列给出的顺序(p[0] , p[1] … p[n-1])依次连接这 n 个字符串都能得到一个长度为这些字符串长度之和的字符串。所以按照这个方法一共可以生成 n! 个字符串。
 * <p>
 * 一个字符串的权值等于把这个字符串循环左移 i 次后得到的字符串仍和原字符串全等的数量，i 的取值为 [1 , 字符串长度]。求这些字符串最后生成的 n! 个字符串中权值为 K 的有多少个。
 * <p>
 * 注：定义把一个串循环左移 1 次等价于把这个串的第一个字符移动到最后一个字符的后面。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为两个正整数 n, K ， n 的大小不超过 8 ， K 不超过 200。接下来有 n 行，每行一个长度不超过 20 且仅包含大写字母的字符串。
 * <p>
 * 输出描述:
 * 输出一个整数代表权值为 K 的字符串数量。
 * <p>
 * 输入例子1:
 * 3 2
 * AB
 * RAAB
 * RA
 * <p>
 * 输出例子1:
 * 3
 *
 * @author Heper
 * @title 魔法权值
 * @date 2019/3/15 23:10
 */
public class Dev2017_3 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/8c759758b2e746a18a31b4eee5d4000b
     * 来源：牛客网
     * <p>
     * 按照输入和输出给的样例，结合题干，就基本可以正确猜出出题人的意思了。
     * <p>
     * 第一行输入 3 2，即 n = 3, K = 2
     * 紧接着是 n 行输入：
     * AB
     * RAAB
     * RA
     * <p>
     * 主要是 K 表达的含义： K 代表一个字符串的权值，最终结果让程序输出 权值等于K 的数量（count(K)），权值就是等于把一个字符串循环左移 i 次后得到的字符串仍和原字符串全等的数量 ，又特么是数量。
     * <p>
     * 假设 一个字符串循环左移 i 次后 得到的字符串仍和原字符串全等 情况设为 is_eq_after_move(i) ， 其中 i 的取值为 [1, 字串长度]， 则 K = count (is_eq_after_move(i) )， 即这些情况的总数。因为 i 最大值可以取到 字符长度， 所以 K 的最小值是 1。
     * <p>
     * K 的含义基本清楚了，那字符串有如何生成？
     * <p>
     * 根据题意 字符串会有 n! 个情况，能将 n 个字符串组装成 n! 个 新的 字符串，想到的只有 全排列 了 。可以根据 输入输出例子 验证这个猜测。
     * <p>
     * 验证如下：
     * n = 3, K = 2
     * 全排列：
     * AB RAAB RA   (偏移后和原串相等的偏移量 i = 4， 8) ，则 K = count(i) = 2
     * AB RA RAAB   (偏移量 i = 8), 则 K = count(i) = 1
     * RAAB AB RA ( 偏移量 i = 8), 则 K = count(i) = 1
     * RAAB RA AB ( 偏移量 i = 4, 8), 则 K = count(i) = 2
     * RA AB RAAB ( 偏移量 i = 4, 8), 则 K = count(i) = 2
     * RA RAAB AB ( 偏移量 i = 8), 则 K = count(i) = 1
     * <p>
     * 则 输出 K == 2 的数量： count(K == 2) = 3
     * 正是 输出例子给出的数字 3。
     * <p>
     * 至此理解题意了。
     * 接下来只需搞定， 生成全排列 的 算法，和 验证 偏移 offset 个字符 后和原串相等 的算法 就可以了。
     */

    static ArrayList<String> res;

    public static int next(String arr) {
        int[] next = new int[arr.length() + 1];
        int res = 1;
        next[0] = next[1] = 0;
        int j = 0;
        for (int i = 1; i < arr.length(); i++) {
            while (j > 0 && arr.charAt(i) != arr.charAt(j)) {
                j = next[j];
            }
            if (arr.charAt(i) == arr.charAt(j)) {
                j++;
            }
            next[i + 1] = j;
        }
        if (arr.length() % (arr.length() - next[arr.length()]) == 0) {
            res = arr.length() / (arr.length() - next[arr.length()]);
        }
        return res;
    }

    public static void allString(String[] strr, int s, int n) {
        String tmp;
        if (s == (n - 1)) {
            tmp = "";
            for (int i = 0; i < n; i++) {
                tmp += strr[i];
            }
            res.add(tmp);
        }
        for (int i = s; i < n; i++) {
            tmp = strr[s];
            strr[s] = strr[i];
            strr[i] = tmp;
            allString(strr, s + 1, n);
            tmp = strr[s];
            strr[s] = strr[i];
            strr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, count;
        String[] strr;
        while (sc.hasNext()) {
            res = new ArrayList<>();
            count = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            strr = new String[n];
            for (int i = 0; i < n; i++) {
                strr[i] = sc.next();
            }
            allString(strr, 0, n);
            for (int i = 0; i < res.size(); i++) {
                if (next(res.get(i)) == k) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
