package niuke.sword.offer;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 *
 * @Author : Heper
 * @Time : 2019/2/2 22:42
 */
public class FindNumsAppearOnce {
    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     */
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int result = 0;
        for (int i : array) {
            result ^= i;
        }
        //找到result的不为0的第一个字节
        //如何找呢
        int pos = 1;
        while ((result & 1) == 0) {
            result = result >> 1;
            //记录1出现的位置
            pos = pos << 1;
        }
        for (int i : array) {
            //依据该位置上是否为1将数组拆分为两部分
            if ((i & pos) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}
