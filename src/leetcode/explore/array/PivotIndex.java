package leetcode.explore.array;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int index = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int lowSum = 0;
        int highSum;
        while (index < nums.length) {
            highSum = sum - lowSum - nums[index];
            if (lowSum == highSum) {
                return index;
            }
            lowSum += nums[index];
            index++;
        }
        return -1;
    }
}
