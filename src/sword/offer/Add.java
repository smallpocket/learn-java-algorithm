package sword.offer;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * TODO:位运算没学好
 *
 * @Author : Heper
 * @Time : 2019/2/3 21:13
 */
public class Add {
    /**
     * 第一感觉应该是使用位运算
     * &与运算，即都为1才为1、|或运算，即都为0才为0、
     * ^异或，即相同为0，相反为1
     * ~取反、<<左移、>>右移动
     *
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1, int num2) {
        //如果没有进位,则都是0了
        while (num2 != 0) {
            //这是一次加法,但是无法计算进位置
            int temp = num1 ^ num2;
            //这是一次进位,因为相同则为1,则可认为是加上去了,
            // 既然加上去了,则进位,即左移动
            //FIXME:位运算要加上数字
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    /**
     * 解法2,自增自减版
     */
//    public int Add(int num1,int num2) {
//        if(num1>0){
//            while(num1--!=0)
//                num2++;
//        }
//        else if(num1<0){
//            while(num1++!=0)
//                num2--;
//        }
//        return num2;
//    }
}
