package sarch;

/**
 * @author Heper
 * @title 顺序查找
 * @date 2019/2/12 22:14
 */
public class SequenceSearch {
    public int sequenceSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
