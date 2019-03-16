package bytedis.exam.result;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/3/16 10:08
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //行数
            int line = in.nextInt();
            int a, b;
            //记录上一个A、B字符
            char ac, bc = ' ';

            for (int i = 0; i < line; i++) {
                //记录AABB型中出现的次数
                a = 0;
                b = 0;
                //三个相同字母一定是错误
                //AABB转为AAB
                String str = in.next();
                ac = str.charAt(0);
                //存放构造出的字符串
                StringBuilder sb = new StringBuilder();
                //首先遇到重复字母，a增加
                //只有a到达2时，才考虑b
                //当a==1时出现新字母，则更新c
                for (int j = 0; j < str.length(); j++) {
                    if (a < 2) {
                        if (ac == str.charAt(j)) {
                            a++;
                        } else {
                            //更新字母
                            ac = str.charAt(j);
                            bc = ' ';
                        }
                        sb.append(ac);
                    } else if (a == 2) {
                        if (ac == str.charAt(j)) {
                            ///AAA模型
                            continue;
                        } else if ((b == 1 && bc == str.charAt(j))) {
                            //AABB模型，跳过最后一个B
                            continue;
                        } else if (b == 0) {
                            //AAB模型，加入B
                            bc = str.charAt(j);
                            b++;
                            sb.append(bc);
                        } else {
                            //AABC模型
                            a = 1;
                            ac = str.charAt(j);
                            b = 0;
                            bc = ' ';
                            sb.append(ac);
                        }

                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}
