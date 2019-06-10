package question.pinduoduo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/5/6 19:29
 */
public class MainIII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int need = in.nextInt();
        int[] high = new int[num];
        for (int i = 0; i < num; i++) {
            high[i] = in.nextInt();
        }
        Arrays.sort(high);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = num - 1; i > 0; i--) {
            int res = 0;
            int base = high[i];
            if (map.containsKey(base)) {
                continue;
            }
            for (int j = 0; j < need; j++) {
                if (i - j > 0) {
                    res += base - high[i - j];
                } else {
                    res = Integer.MAX_VALUE;
                }
                map.put(base, res);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) < result) {
                result = map.get(key);
            }
        }
        System.out.println(result);
    }
}
