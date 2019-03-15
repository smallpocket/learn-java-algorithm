package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/9 21:43
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 0 && array[i + 1] % 2 == 1) {
                swap(array, i, i + 1);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
