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

    public int[] arr;

    private int min;

    public int[] countSort() {
        int b[] = new int[arr.length];
        int k = getBucketNum();

        int c[] = new int[k];
        for (int i = 0; i < arr.length; i++) {
            c[arr[i] - min] += 1;//优化过的地方，减小了数组c的大小
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            b[--c[arr[i] - min]] = arr[i];//按存取的方式取出c的元素
        }
        return b;
    }

    /**
     * 获得桶的数目
     *
     * @return
     */
    private int getBucketNum() {
        int max = arr[0], mins = arr[0];
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
            if (mins > a) {
                mins = a;
            }
        }
        this.min = mins;
        return max - mins + 1;
    }


}
