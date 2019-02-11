package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，
 * 对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这
 * 类文章喜好值为k。因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 * <p>
 * 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数
 * 第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数
 * 据范围n <= 300000,q<=300000 k是整型
 * <p>
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 * <p>
 * 输入例子1:
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 * <p>
 * 输出例子1:
 * 1
 * 0
 * 2
 * <p>
 * 样例解释:
 * 有5个用户，喜好值为分别为1、2、3、3、5，
 * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 *
 * @author Heper
 * @title 用户喜好
 * @date 2019/2/11 14:08
 */
public class User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //如果有输入
        while (scanner.hasNextLine()) {
            //使用map进行关联
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            //用户个数
            int users = Integer.parseInt(scanner.nextLine());
            //用户对某类文章的喜好度
            String hobby = scanner.nextLine();
            String[] hobbyArr = hobby.split("\\s+");
            int[] hobbys = new int[hobbyArr.length];
            for (int i = 0; i < hobbyArr.length; i++) {
                hobbys[i] = Integer.parseInt(hobbyArr[i]);
                if (!map.containsKey(hobbys[i])) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i + 1);
                    map.put(hobbys[i], arrayList);
                } else {
                    map.get(hobbys[i]).add(i + 1);
                }
            }
            //查询次数
            int count = Integer.parseInt(scanner.nextLine());
            //查询的字符串
            String select;
            String[] dates;
            int[] date = new int[3];
            for (int i = 0; i < count; i++) {
                int num = 0;
                select = scanner.nextLine();
                dates = select.split(" ");
                //获得一个组
                date[0] = Integer.parseInt(dates[0]);
                date[1] = Integer.parseInt(dates[1]);
                date[2] = Integer.parseInt(dates[2]);
                ArrayList<Integer> arrayList = map.get(date[2]);
                for (int k : arrayList
                ) {
                    if (k >= date[0] && k <= date[1]) {
                        num++;
                    }
                    if (k > date[1]) {
                        break;
                    }
                }
                System.out.println(num);
            }

        }
    }
}
