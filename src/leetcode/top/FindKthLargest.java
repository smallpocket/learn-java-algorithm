package leetcode.top;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author Heper
 * @title 数组中的第K个最大元素
 * @date 2019/2/20 14:30
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //在排序数组当中，第k大的数的index
        k = nums.length - k;
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            int j = partition(nums, head, tail);
            if (j == k) {
                break;
            } else if (j < k) {
                head = j + 1;
            } else {
                tail = j - 1;
            }
        }
        return nums[k];
    }


    public int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) {
            }
            while (a[--j] > a[l] && j > l) {
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
