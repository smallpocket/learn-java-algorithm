package niuke.sword.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @Title: 表示数值的字符串
 * @Author : Heper
 * @Time : 2019/2/4 16:02
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str.length == 0) {
            return false;
        }
        //标记正负号、小数点、E
        boolean zero = false, e = false;
        int type = 0;
        if (str[0] == '+' || str[0] == '-') {
            type = 1;
        }
        for (int i = type; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                continue;
            } else if (str[i] == '.' && !zero && !e) {
                zero = true;
                if (readNum(str, i + 1, 0)) {
                    continue;
                }
            } else if ((str[i] == 'E' || str[i] == 'e') && !e) {
                e = true;
                if (readNum(str, i + 1, 1)) {
                    if (str[i + 1] == '+' || str[i + 1] == '-') {
                        i = i + 2;
                    }
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断后面是否存在真实的数字
     *
     * @param str
     * @param index
     * @param type  判断是否需要检验正负号
     * @return
     */
    public boolean readNum(char[] str, int index, int type) {
        if (index < str.length && type == 1) {
            if (str[index] == '+' || str[index] == '-') {
                index = index + 1;
            }
        }
        if (index < str.length && str[index] >= '0' && str[index] <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsNumeric isNumeric = new IsNumeric();
//        char[] num = {'1', '2', '3', '.', '4', '5', 'e', '+', '6'};
        char[] num = {'1', '2', 'e', '+', '5', '.', '4'};
        if (isNumeric.isNumeric(num)) {
            System.out.println("test");
        }
    }
}
