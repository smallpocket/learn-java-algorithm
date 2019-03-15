package leetcode;

/**
 * @author Heper
 * @title
 * @date 2019/2/20 16:22
 */
public class Test {
    public static void main(String[] args) {

        int[] arr = {
                1, 2, 3, 4, 5
        };
        for (int i : arr) {
            i = i + 1;
        }
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
