import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/2/11 19:39
 */
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int startIndex = 0; startIndex < nums.length - 2; startIndex++) {
            if (nums[nums.length - 2] + nums[startIndex] > nums[nums.length - 1]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}

class Main {
    private static Node[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int operate = sc.nextInt();
        nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node(sc.nextInt());
        }
        Arrays.sort(
                nodes,
                new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o2.value - o1.value;
                    }
                });

        for (int i = 0; i < operate; i++) {
            int index = rank(sc.nextInt(), nodes);
            System.out.println(nodes.length - index);
        }
    }

    public static int rank(int key, Node[] nodes) {
        // 定义数组的开始和结尾
        int low = 0;
        int high = nodes.length - 1;
        // 当开始端与结尾端没有在一个地方，就继续进行查找
        while (low <= high) {
            // 判断中间的元素与要查找的key的大小关系
            int mid = low + (high - low) / 2;
            // 判断与key的关系
            if (key < nodes[mid].value) {
                high = mid - 1;
            } else if (key > nodes[mid].value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        // low与high碰面了,退出了循环,说明没有查找到相应的元素,返回-1
        return low;
    }
}

class Node {
    public int value;
    public int minus;

    public Node(int val) {
        value = val;
    }
}

class HeapSort {
    private Node[] arr;

    public HeapSort(Node[] arr) {
        this.arr = arr;
    }

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort() {
        /**
         * 第一步：将数组堆化 beginIndex = 第一个非叶子节点。 从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len);
        }
        /**
         * 第二步：对堆化数据排序 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。 直至未排序的堆长度为
         * 0。
         */
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }

    private void swap(int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void maxHeapify(int index, int len) {
        // 左子节点索引
        int li = (index << 1) + 1;
        // 右子节点索引
        int ri = li + 1;
        // 子节点值最大索引，默认左子节点。
        int cMax = li;
        // 左子节点索引超出计算范围，直接返回。
        if (li > len) {
            return;
        }
        // 先判断左右子节点，哪个较大。
        if (ri <= len && arr[ri].value > arr[li].value) {
            cMax = ri;
        }
        if (arr[cMax].value > arr[index].value) {
            // 如果父节点被子节点调换，
            swap(cMax, index);
            // 则需要继续判断换下后的父节点是否符合堆的特性。
            maxHeapify(cMax, len);
        }
    }

    /**
     * 测试用例
     *
     * <p>输出： [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9,
     * 9]
     */
    //    public static void main(String[] args) {
    //        Node[] arr =
    //                new Node[]{
    //                        3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5,
    // 9, 7, 4, 0, 2, 6
    //                };
    //        new HeapSort(arr).sort();
    //        System.out.println(Arrays.toString(arr));
    //    }
}
