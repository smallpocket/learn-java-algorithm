package bytedis.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9
 * 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整
 * 数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不
 * 超过 12 且仅包含大写字母 A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 * <p>
 * 输出描述:
 * 输出一个数，表示最大和是多少。
 * <p>
 * 输入例子1:
 * 2
 * ABC
 * BCA
 * <p>
 * 输出例子1:
 * 1875
 *
 * @author Heper
 * @title 最大映射
 * @date 2019/3/15 23:07
 */
public class Dev2017_1 {

    /**
     * 就是利用权重来计算
     * <p>
     * 输入例子：
     * ABC
     * BCA
     * <p>
     * 设 table = A B C D E F G H I J
     * 个位权值 为 1
     * 十位权值 为 10
     * 百位权值 为 100
     * 依次类推， 没有出现的字母权值为 0
     * <p>
     * 则 A 的权重为 100 + 1  = 101
     * B 的权重为    10 + 100 = 110
     * C 的权重为    1 + 10   = 11
     * D - J 的权重为   0
     * <p>
     * 即 依照 table 的字母排列顺序，权重表为
     * weight = 101  110 11 0 0 0 0 0 0
     * <p>
     * 进而得到
     * 映射值表
     * ret    = 8    9   7 0 0 0 0 0 0
     * <p>
     * 将 (权重表 x 映射表)，然后再累加起来就是题目要的答案
     * <p>
     * 则这些数的和为 (101 * 8) + (110 * 9) + (11 * 7) + 0 + ... + 0 = 1875
     * <p>
     * 具体细节 和 实现代码如下
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        while (s.hasNext()) {
            n = s.nextInt();
            String[] str = new String[n];
            Element[] e = new Element[10];
            for (int i = 0; i < 10; i++) {
                e[i] = new Element();
            }
            for (int i = 0; i < n; i++) {
                str[i] = s.next();
                int l = str[i].length();
                long base = 1;
                for (int j = l - 1; j >= 0; j--) {
                    int idx = str[i].charAt(j) - 'A';
                    //如果该字母出现在首部，则标记为不能为0；即flag标记为false
                    if (j == 0) {
                        e[idx].flag = false;
                    }
                    e[idx].weight += base;
                    base *= 10;
                }
            }
            Arrays.sort(e, new Comparator<Element>() {

                @Override
                public int compare(Element o1, Element o2) {
                    return o1.weight > o2.weight ? 1 : (o1.weight == o2.weight ? 0 : -1);
                }
            });
            long sum = 0;
            //权值最低且不能为0的情况
            if (!e[0].flag) {
                int k = 0;
                for (; k < 10; k++) {
                    if (e[k].flag) {
                        break;
                    }
                }
                Element tmp = e[k];
                for (; k > 0; k--) {
                    e[k] = e[k - 1];
                }
                e[0] = tmp;
            }
            //权值越大映射的值越大
            for (int i = 9; i >= 0; i--) {
                sum += e[i].weight * i;
            }
            System.out.println(sum);
        }
    }

    static class Element {
        //表示权值
        long weight = 0;
        //表示该字母是否可以为0 false表不可以为0；true表可以为0
        boolean flag = true;
    }
}
