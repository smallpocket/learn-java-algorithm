package base.sort;

/**
 * @author Heper
 * @title
 * @date 2019/3/22 17:30
 */
public class Test {
    private int[] arr;

    public Test(int[] arr) {
        this.arr = arr;
    }

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
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
