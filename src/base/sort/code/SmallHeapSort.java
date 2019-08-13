package base.sort.code;

/**
 * 小根堆
 *
 * @param <T>
 */
interface SmallHeapSortInterface<T extends Comparable<T>> {
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

public class SmallHeapSort<T extends Comparable<T>> extends Sort implements SmallHeapSortInterface {
    @Override
    public void swim(int k) {

    }

    @Override
    public void sink(int k) {

    }

    @Override
    public void insert(Comparable v) {

    }

    @Override
    public Comparable delMax() {
        return null;
    }

    @Override
    public void initBigHeap() {

    }

    @Override
    public void sort() {

    }
}
