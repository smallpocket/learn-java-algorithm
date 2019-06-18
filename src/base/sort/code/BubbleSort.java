package base.sort.code;

/**
 * @Title : 冒泡排序
 * @Author : Heper
 * @Time : 2019/2/6 14:16
 */
public class BubbleSort {
    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //end代表数组的结尾。也是在该次循环当中，end位置的元素会有序
        for (int end = arr.length - 1; end > 0; end--) {
            //进行两两比较，
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
