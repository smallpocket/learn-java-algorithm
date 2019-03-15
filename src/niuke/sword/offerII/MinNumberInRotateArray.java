package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/8 20:40
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (array[mid] < array[high]) {
                high = mid;
            } else if (array[mid] == array[high]) {
                high--;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            }
        }
        return array[low];
    }
}
