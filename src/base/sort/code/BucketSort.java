package base.sort.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序 (Bucket base.sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 * <p>
 * 算法描述
 * 设置一个定量的数组当作空桶；
 * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 对每个不是空的桶进行排序；
 * 从不是空的桶里把排好序的数据拼接起来。
 *
 * @Title : 桶排序
 * @Author : Heper
 * @Time : 2019/2/6 14:18
 */
public class BucketSort {

    public int[] arr;

    private int indexFor(int a, int min, int step) {
        return (a - min) / step;
    }

    /**
     * 出现频率最多的 k 个数
     */
    public void sort() {
        int max = arr[0], min = arr[0];
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
            if (min > a) {
                min = a;
            }
        }
        // 该值也可以根据实际情况选择
        int step = 10;
        int bucketNum = max / step - min / step + 1;
        List buckList = createBucket(bucketNum);
        // push into the bucket
        for (int i = 0; i < arr.length; i++) {
            int index = indexFor(arr[i], min, step);
            ((ArrayList<Integer>) buckList.get(index)).add(arr[i]);
        }
        ArrayList<Integer> bucket = null;
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            bucket = (ArrayList<Integer>) buckList.get(i);
            insertSort(bucket);
            for (int k : bucket) {
                arr[index++] = k;
            }
        }

    }

    /**
     * @param bucketNum 桶的数目
     * @return
     */
    private List<List<Integer>> createBucket(int bucketNum) {
        List<List<Integer>> bucketList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= bucketNum; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        return bucketList;
    }

    /**
     * 把桶內元素插入排序
     */
    private void insertSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int temp = bucket.get(i);
            int j = i - 1;
            for (; j >= 0 && bucket.get(j) > temp; j--) {
                bucket.set(j + 1, bucket.get(j));
            }
            bucket.set(j + 1, temp);
        }
    }
}
