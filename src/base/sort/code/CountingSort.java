package base.sort.code;

/**
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 *
 * @Ttitle : 计数排序
 * @Author : Heper
 * @Time : 2019/2/6 14:18
 */
public class CountingSort {
    public int[] countSort(int[] array, int k) {
        //构造C数组
        int[] C = new int[k + 1];
        //获取A数组大小用于构造B数组
        int length = array.length, sum = 0;
        //构造B数组
        int[] B = new int[length];
        for (int i = 0; i < length; i++) {
            // 统计A中各元素个数，存入C数组
            C[array[i]] += 1;
        }
        //修改C数组
        for (int i = 0; i < k + 1; i++) {
            sum += C[i];
            C[i] = sum;
        }
        //遍历A数组，构造B数组
        for (int i = length - 1; i >= 0; i--) {
            //将A中该元素放到排序后数组B中指定的位置
            B[C[array[i]] - 1] = array[i];
            //将C中该元素-1，方便存放下一个同样大小的元素
            C[array[i]]--;

        }
        //将排序好的数组返回，完成排序
        return B;
    }
}
