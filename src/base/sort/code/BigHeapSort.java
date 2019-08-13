package base.sort.code;

import java.util.Arrays;

/**
 * 大根堆，2i+1为左子节点，2i+2为右子节点。(k-1)/2为父节点
 * 堆排序也可以用于求解 Kth Element 问题，堆顶元素就是 Kth Element。
 * 用于求解 TopK Elements 问题，通过维护一个大小为 K的堆，堆中的元素就是 TopK Elements。
 */
interface BigHeapSortInterface<T extends Comparable<T>> {
    /**
     * 上浮。当一个节点比父节点大，那么需要交换这个两个节点。交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操作
     *
     * @param k 需要上浮的节点在数组中的index
     */
    void swim(int k);

    /**
     * 下沉。当一个节点比子节点来得小，也需要不断地向下进行比较和交换操作
     *
     * @param k 需要下沉节点在数组中的index
     */
    void sink(int k);

    /**
     * 将新元素放到数组末尾，然后上浮到合适的位置。
     *
     * @param v 需要插入的元素
     */
    void insert(Comparable v);

    /**
     * 数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
     *
     * @return 最大元素
     */
    T delMax();

    /**
     * 生成大根堆
     */
    void initBigHeap();
}

/**
 *
 * @author Heper
 * @title
 * @date 2019/2/16 21:04
 */
public class BigHeapSort<T extends Comparable<T>> extends Sort implements BigHeapSortInterface {

    public BigHeapSort(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }


    @Override
    public void swim(int k) {
        if (k <= 0) {
            return;
        }
        int father = (k - 1) / 2;
        if (less(arr[father], arr[k])) {
            swap(father, k);
            swim(father);
        }
    }

    @Override
    public void sink(int k) {
        int left = 2 * k + 1;
        int right = left + 1;
        if (left >= size) {
            return;
        }
        int cMax = left;
        if (right < size && less(arr[left], arr[right])) {
            cMax = right;
        }
        if (less(arr[k], arr[cMax])) {
            swap(cMax, k);
            sink(cMax);
        }
    }


    @Override
    public void insert(Comparable v) {
        arr[++size] = v;
        swim(size);
    }

    @Override
    public T delMax() {
        T max = (T) arr[0];
        swap(0, size--);
        arr[size + 1] = null;
        sink(0);
        return max;
    }

    @Override
    public void initBigHeap() {
        int beginIndex = (size >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            sink(i);
        }
    }


    @Override
    public void sort() {
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            sink(0);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        BigHeapSort<Integer> bigHeapSort = new BigHeapSort<>(arr);
        bigHeapSort.initBigHeap();
        bigHeapSort.sort();
        System.out.println(Arrays.toString(bigHeapSort.arr));
    }


}