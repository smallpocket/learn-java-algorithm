package base.sort.code;

/**
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）
 * 它的父节点。
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
 * 且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后
 * 再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断
 * 重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * @Title : 堆排序
 * @Author : Heper
 * @Time : 2019/2/6 14:18
 */
public class HeapSortI {
    private int len;

    /**
     * 大根堆的构建
     * 从最后一个非叶子节点为父节点的子树出发，从右往左，从下往上进行调整操作（怎么调整下面讲）。这里需注意的是：
     * a.是以该非叶子节点为父节点的子树，即该父节点以下的所有部分都进行调整操作。
     * b.由于是从右往左从下往上，则某一步进行调整时在调整它之前的那些子树已经是堆有序了，即走到某个非叶子节点时，它的子树已经是堆有序了（因为是从下往上）
     * 如果该节点比它的两个孩子节点都大，则该节点不用调整了，因为它的孩子节点也是堆有序
     *
     * @param arr
     */
    public void buildMaxHeap(int[] arr) {
        len = arr.length;
        //中间的元素应该是顶部元素
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    /**
     * 将大元素调整上去
     *
     * @param arr
     * @param i
     */
    public void heapify(int[] arr, int i) {
        //i 的左孩子结点与右孩子结点
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    /**
     * 交换数据
     *
     * @param arr
     * @param i
     * @param largest
     */
    public void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    public void heapSort(int[] arr) {
        //arr按照顺序存放,构造一颗完全二叉树
        //例如[2,3,4,5,6,7,8]
        //    2
        //  3   4
        //5  6 7 8
        //从下到上,从右到左选择一个非叶子结点开始调整
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
    }
}
