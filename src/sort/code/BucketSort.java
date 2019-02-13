package sort.code;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
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
    public int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }

        int i;
        int minValue = arr[0];
        int maxValue = arr[0];
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                // 输入数据的最小值
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                // 输入数据的最大值
                maxValue = arr[i];
            }
        }

        // 桶的初始化
        int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
        int[] buckets = new int[bucketCount];

        // 利用映射函数将数据分配到各个桶中
        for (i = 0; i < arr.length; i++) {
            buckets[(int) Math.floor((arr[i] - minValue) / bucketSize)] = arr[i];
        }

//        for (i = 0; i < buckets.length; i++) {
//            insertionSort(buckets[i]);                      // 对每个桶进行排序，这里使用了插入排序
//            for (var j = 0; j < buckets[i].length; j++) {
//                arr.push(buckets[i][j]);
//            }
//        }

        return arr;
    }
}
