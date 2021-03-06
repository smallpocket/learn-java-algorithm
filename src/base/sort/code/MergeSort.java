package base.sort.code;

/**
 * @Title : 归并排序
 * @Author :Heper
 * @Time : 2019/2/6 14:17
 */
interface MergeSortInterface {
    /**
     * 将长度为n的输入序列分为两个长度为n/2的子序列； 对这两个子序列分别采用归并排序； 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param low
     * @param high
     */
    public void mergeSort(int low, int high);

    /**
     * 排序规则：小->大
     * 将两个已经排序好的子区间合并为一个已经有序的区间
     * 需要O（N）空间复杂度
     *
     * @param low
     * @param middle
     * @param high
     */
    public void merge(int low, int middle, int high);
}

public class MergeSort implements MergeSortInterface {

    public int[] arr;

    public MergeSort(int[] array) {
        this.arr = array;
    }

    @Override
    public void mergeSort(int low, int high) {
        //将数组分成两组
        int middle = low + (high - low) / 2;
        if (low < high) {
            //依最小单位的数组
            //先2,(2个数组已经有序)后4
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    @Override
    public void merge(int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int l = low, m = middle + 1, k = 0;
        while (l <= middle && m <= high) {
            //将小数字移动
            if (arr[l] < arr[m]) {
                temp[k++] = arr[l++];
            } else {
                temp[k++] = arr[m++];
            }
        }
        //将左边剩余的数字放进去
        while (l <= middle) {
            temp[k++] = arr[l++];
        }
        while (m <= high) {
            temp[k++] = arr[m++];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[x + low] = temp[x];
        }
    }
}
