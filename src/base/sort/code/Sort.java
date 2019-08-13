package base.sort.code;

public abstract class Sort<T extends Comparable<T>> {
    /**
     * 数组
     */
    public T[] arr;

    /**
     * 数组的有效size
     */
    int size;

    public abstract void sort();

    /**
     * 大于为正数，小于为负数
     * 如果小于则返回true
     *
     * @param v 指元素而不是index
     * @param w 指元素而不是index
     * @return 若v<w ， 则为true
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换index为i与j的元素
     *
     * @param i index
     * @param j index
     */
    protected void swap(int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

