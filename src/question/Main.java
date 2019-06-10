package question;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/10 10:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            long[] number = new long[num];
            for (int i = 0; i < num; i++) {
                number[i] = scanner.nextLong();
            }
            for (long i : number) {
                System.out.println(SplitNumber.numberType(i));
            }
        }
    }

}

class SplitNumber {
    public static Character numberType(long number) {
        long num = number;
        long split = 0;
        int count = 0;
        boolean ifG = true;
        while (num != 0) {
            split = num % 10;
            if (split == 0 || number % split == 0) {
                count++;
            } else {
                ifG = false;
            }
            num /= 10;
//            if (number % split != 0) {
//                if (count == 0) {
//                    return 'S';
//                } else {
//                    break;
//                }
//            }
//            num /= 10;
//            count++;
        }
        if (count == 0) {
            return 'S';
        }
        if (ifG) {
            return 'G';
        }
        return 'H';
    }
}
