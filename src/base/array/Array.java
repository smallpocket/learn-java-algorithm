package base.array;

public class Array<T> {
    private T[] data;
    private int size;

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获得数组长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获得数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 末尾增加元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 在数组头部插入一个元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在指定位置插入一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity
     */
    public void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获得元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("");
        }
        return data[index];
    }

    /**
     * 修改index位置元素的值为e
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("");
        }
        data[index] = e;
    }

    /**
     * 是否存在元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 寻找e的index
     *
     * @param e
     * @return 失败返回-1
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置的元素，并返回删除的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("");
        }
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array:size= %d,capcacity:%d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
