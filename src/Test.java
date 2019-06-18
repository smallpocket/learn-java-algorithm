import java.util.Arrays;

/**
 * @author Heper
 * @title 对数器
 * @date 2019/6/18 13:53
 */
public class Test {
    /**
     * 完全正确的方法
     *
     * @param arr
     */
    public static void bestMethod(int[] arr) {

    }

    /**
     * 时间复杂度低，效果好的方法
     *
     * @param arr
     */
    public static void rightMethod(int[] arr) {

    }

    /**
     * 随机数发生器
     *
     * @param size  生成的数组大小
     * @param value 数组值的范围
     * @return
     */

    public static int[] generateRandomArray(int size, int value) {
        //Math.randrom()->double [0,1)
        //(int) ((size + 1) * Math.random())->[0,size]整数

        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //两个随机数相减，可能产生负数
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    /**
     * 判断最后的结果是否一致
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean ifEquals(int[] arr1, int[] arr2) {
        return true;
    }

    /**
     * 打印错误case
     *
     * @param arr
     */
    public static void printArray(int[] arr) {

    }

    public static void main(String[] args) {
        //测试次数
        int testTime = 50000;
        //size不要太长，以方便自己肉眼寻错
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, size);
            int[] arr3 = Arrays.copyOf(arr1, size);
            rightMethod(arr2);
            bestMethod(arr3);
            if (!ifEquals(arr2, arr3)) {
                succeed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println("Nice");
    }
}
