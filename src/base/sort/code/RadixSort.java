package base.sort.code;

import java.util.Arrays;

/**
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是
 * 有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优
 * 先级高的在前。
 * <p>
 * 算法描述
 * 取得数组中的最大数，并取得位数；
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 *
 * @Title : 基数排序
 * @Author : Heper
 * @Time : 2019/2/6 14:18
 */
public class RadixSort {

    /**
     * 8.基数排序  稳定的排序算法
     *
     * @param array 代表数组
     * @param radix 代表基数
     * @param d     代表排序元素的位数
     */
    public static void radixSort(Integer[] array, int radix, int d) {
        // 临时数组
        Integer[] tempArray = new Integer[array.length];
        // count用于记录待排序元素的信息,用来表示该位是i的数的个数
        Integer[] count = new Integer[radix];

        int rate = 1;
        for (int i = 0; i < d; i++) {
            //重置count数组，开始统计下一个关键字
            Arrays.fill(count, 0);
            //将array中的元素完全复制到tempArray数组中
            System.arraycopy(array, 0, tempArray, 0, array.length);

            //计算每个待排序数据的子关键字
            for (int j = 0; j < array.length; j++) {
                int subKey = (tempArray[j] / rate) % radix;
                count[subKey]++;
            }
            //统计count数组的前j位（包含j）共有多少个数
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            //按子关键字对指定的数据进行排序 ，因为开始是从前往后放，现在从后忘前读取，保证基数排序的稳定性
            for (int m = array.length - 1; m >= 0; m--) {
                int subKey = (tempArray[m] / rate) % radix;
                array[--count[subKey]] = tempArray[m]; //插入到第--count[subKey]位，因为数组下标从0开始
            }
            rate *= radix;//前进一位
            System.out.print("第" + (i + 1) + "次：");
            //print(array);
        }

    }
}