package sort;

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

    public void sort(int[] arr, int head, int tail) {
        if (arr == null || head >= tail || arr.length == 1) {
            return;
        }
        int i = head;
        int j = tail;
        int p = arr[(head + (tail - head) / 2)];
        while (i <= j) {
            while (arr[i] < p) {
                i++;
            }
            while (arr[j] > p) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        sort(arr, head, j);
        sort(arr, i, tail);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
