package sort.code;

/**
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 *
 * @Title : 插入排序
 * @Author : Heper
 * @Time : 2019/2/6 14:17
 */
public class InsertionSort {
    public void insertSort(int[] arr) {
        int temp, j;
        for (int i = 1; i < arr.length - 1; i++) {
            temp = arr[i];
            for (j = i - 1; j > -1; j++) {
                if (arr[i] < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j] = temp;
                    break;
                }
            }

        }
    }
}
