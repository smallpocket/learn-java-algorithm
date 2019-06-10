package question.quickhead;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/13 15:47
 */
public class MainIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] number = str.split(",");
        int a = Integer.parseInt(number[0]);
        int b = Integer.parseInt(number[1]);
        //计算次数
        int depth = 0;
        if (a * b < 0) {
            depth = a;
            a = 0;
        }
        //广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        boolean res = true;
        while (!queue.isEmpty() && res) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                int num = queue.poll();
                if (num - 1 == b || num + 1 == b || num * 2 == b) {
                    System.out.println(depth);
                    res = false;
                    break;
                } else {
                    queue.add(num - 1);
                    queue.add(num + 1);
                    queue.add(num * 2);
                }
            }
        }
    }


}
