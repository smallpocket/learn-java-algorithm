package question.sanliuliu;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/24 19:13
 */
public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int string2int(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        int index = 0;
        //是否为正数
        boolean ifZ = true;
        if (chars[0] == '-') {
            ifZ = false;
            index = 1;
        } else if (chars[0] == '+') {
            index = 1;
        }
        for (; index < chars.length && chars[index] == '0'; index++) {
        }
        //判断是否合法数字
        boolean zero = false;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {

            } else if (chars[i] == '.' && zero == false) {
                zero = true;
            } else {
                return 0;
            }
        }
        for (; index < chars.length; index++) {
            if (chars[index] <= '9' && chars[index] >= '0') {
                num = (chars[index] - '0') + num * 10;
            } else if (chars[index] == '.') {
                break;
            } else {
                return 0;
            }

        }
        if (ifZ) {
            return num;
        } else {
            return num * -1;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }
        res = string2int(_str);
        Integer.parseInt("213");
        System.out.println(String.valueOf(res));

    }
}
