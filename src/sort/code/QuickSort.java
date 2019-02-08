package sort.code;

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
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int parIndex = partition(arr, left, right);
        quickSort(arr, left, parIndex - 1);
        quickSort(arr, parIndex + 1, right);
    }

    /**
     * 快排分区
     *
     * @param arr
     * @param left  左边界,即第一个值,一般选取作基准
     * @param right
     */
    public int partition(int[] arr, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
