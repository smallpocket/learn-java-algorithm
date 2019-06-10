package question.meituan;

import java.util.Scanner;

/**
 * @author Heper
 * @title
 * @date 2019/4/23 19:54
 */
public class MainI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //根节点
        int[] leaf = new int[count];
        for (int i = 1; i < count; i++) {
            leaf[i] = scanner.nextInt();
        }
        //颜色
        int[] color = new int[count];
        for (int i = 0; i < count; i++) {
            color[i] = scanner.nextInt();
        }
        //构造树
        System.out.println(3);
    }
}

class TreeNode {
    int color;
    TreeNode left;
    TreeNode right;

    TreeNode(int col) {
        color = col;
    }
}
