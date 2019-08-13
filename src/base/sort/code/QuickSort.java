package base.sort.code;

import java.util.Arrays;

/**
 * 使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面
 * （相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 在小数组当中，快排依然会递归调用自己，此时插入排序的性能更好
 *
 * @Title : 快速排序 小->大
 * @Author : Heper
 * @Time : 2019/2/6 14:17
 */
interface QuickSortInterface {
    /**
     * 切分排序
     * 用于求解 Kth Element 问题，使用快速排序的 partition() 进行实现。
     *
     * @param head
     * @param tail
     */
    void partitionSort(int head, int tail);

    /**
     * 三向切分算法
     *
     * @param head
     * @param tail
     */
    void threeWayQuickSort(int head, int tail);

    /**
     * 切分
     *
     * @param head
     * @param tail
     * @return
     */
    int partition(int head, int tail);

    /**
     * 用于求解 Kth Element 问题，使用快速排序的 partition() 进行实现。
     *
     * @param k
     * @return
     */
    int select(int k);
}

public class QuickSort implements QuickSortInterface {
    public int[] arr;

    public QuickSort(int[] array) {
        this.arr = array;
    }

    @Override
    public void partitionSort(int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = partition(head, tail);
        partitionSort(head, mid);
        partitionSort(mid + 1, tail);
    }

    @Override
    public void threeWayQuickSort(int head, int tail) {
        if (head >= tail) {
            return;
        }
        int lt = head, i = head + 1, j = tail;
        int v = arr[head];
        while (i <= j) {
            if (arr[i] < v) {
                swap(lt++, i++);
            } else if (arr[i] > v) {
                swap(i, j--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(head, lt - 1);
        threeWayQuickSort(lt + 1, tail);
    }

    @Override
    public int partition(int head, int tail) {
        int i = head, j = tail, pivot = arr[head + (tail - head) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                swap(i++, j--);
            } else if (i == j) {
                ++i;
            }
        }
        return j;
    }

    @Override
    public int select(int k) {
        int l = 0, h = arr.length - 1;
        while (h > l) {
            int j = partition(l, h);
            if (j == k) {
                return arr[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return arr[k];
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
