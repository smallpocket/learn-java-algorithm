package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/10 23:21
 */
public class MoreThanHalfNum_Solution {
    /**
     * （注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字
     * 。如果剩下两个，那么这两个也是一样的，就是结果），在其基础上把最后剩下的一个数字或者两个回到
     * 原来数组中，将数组遍历一遍统计一下数字出现次数进行最终判断。
     * <p>
     * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同
     * ，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字
     * 即为所求。然后再判断它是否符合条件即可。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int times = 0;
        int number = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        number = array[0];
        if (array.length < 3) {
            return array[0];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                times++;
            } else {
                times--;
                if (times == 0) {
                    number = array[i];
                    times++;
                }
            }
        }
        //TODO:还需要再遍历一次
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                times++;
            }
        }

        if (times * 2 < array.length) {
            number = 0;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
