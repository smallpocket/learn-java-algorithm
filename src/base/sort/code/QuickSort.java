package base.sort.code;

/**
 * 使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面
 * （相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区
 * （partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * @Title : 快速排序
 * @Author : Heper
 * @Time : 2019/2/6 14:17
 */
public class QuickSort {
    /**
     * 用于求解 Kth Element 问题，使用快速排序的 partition() 进行实现。
     * 需要先打乱数组，否则最坏情况下时间复杂度为 O(N2)。
     *
     * @param arr
     * @param head
     * @param tail
     */
    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
