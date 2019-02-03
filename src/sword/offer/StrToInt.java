package sword.offer;

/**
 * 把字符串转换为整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库
 * 函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @Author : Heper
 * @Time : 2019/2/3 21:32
 */
public class StrToInt {
    /**
     * Input:输入一个字符串,包括数字字母符号,可以为空
     * +2147483647
     * 1a33
     * Out:如果是合法的数值表达则返回该数字，否则返回0
     * 2147483647
     * 0
     */
    public static int strToInt(String str) {
        //存放字符串的字符数组
        char[] nums;
        //判断是否存在数字的符号
        int start = 0;
        //判断数字类型,0为正数,1为负数
        int type = 0;
        //存放最终数字
        int number = 0;
        //FIXME:这里不应该有空格的
        //if (str.equals(" ") || str.length() == 0) {
        if (str.equals("") || str.length() == 0) {
            return 0;
        }
        //trim()函数,删除字符串的头尾空白符。
        //转换为一个字符串数组
        nums = str.trim().toCharArray();

        if (nums[start] == '+') {
            start = 1;
        } else if (nums[start] == '-') {
            start = 1;
            type = 1;
        }
        //截取得到的数字
        int num;
        for (int i = nums.length - 1; i >= start; i--) {
            if (nums[i] >= '0' && nums[i] <= '9') {

                num = (int) (nums[i] - '0');
                number = (int) (number + num * Math.pow(10, nums.length - i - 1));
            } else {
                System.out.println(0);
                return 0;
            }
        }
        if (type == 1) {
            number = -number;
        }
        System.out.println(number);
        return 0;
    }

    public static void main(String[] args) {
        strToInt("    1a33");
    }
}
