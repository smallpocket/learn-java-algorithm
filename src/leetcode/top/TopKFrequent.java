package leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heper
 * @title
 * @date 2019/2/20 14:49
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //数字出现的频数
        //使用map存放数字与数字出现的频数
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
            }
        }
        return topK;

    }
}
