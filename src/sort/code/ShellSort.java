package sort.code;

/**
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入
 * 排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * @Title : 希尔排序
 * @Author : Heper
 * @Time : 2019/2/6 14:17
 */
public class ShellSort {
    //TODO:
    public void shellSort(int[] arr) {
        int gap = 1, temp;
        if (gap < arr.length / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap = (int) Math.floor(gap / 3)) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for (int j = i - gap; j > 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
            }
        }
    }
}
