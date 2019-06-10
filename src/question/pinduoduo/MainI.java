package question.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/5/6 19:01
 */
public class MainI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int count = 0;
        boolean[] exist = new boolean[str.length()];
        Arrays.fill(exist, false);
        for (int i = 0; i < str.length(); i++) {
            count += test(str, exist, i);
        }
        System.out.println(count);
    }

    public static int test(String str, boolean[] exist, int index) {
        int count = 0;
        int past = index - 1;
        while (past >= 0 && exist[past] == true) {
            past--;
        }
        while (past >= 0 && index < str.length() && str.charAt(past) == str.charAt(index)) {
            count++;
            exist[past] = true;
            exist[index] = true;
            while (past >= 0 && exist[past] == true) {
                past--;
            }
        }
        return count;
    }
}
