package base.sort.code;

/**
 * 从第一个元素开始，该元素可以认为已经被排序；取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置(或者说与需要排序的元素交换)；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后。重复步骤2~5。
 *
 * @Title : 插入排序
 * @Author : Heper
 * @Time : 2019/2/6 14:17
 */
public class InsertionSort {
    /**
     * 时间复杂度与数据的状态有关，如果原数组有序，则复杂度为ON
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            //当新插入的元素大于排在后面的元素，则进行交换
            //当小于时，则停止
            for (int j = i - 1; j > -1 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
