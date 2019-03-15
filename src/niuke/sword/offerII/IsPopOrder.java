package niuke.sword.offerII;

import java.util.Stack;

/**
 * @author Heper
 * @title
 * @date 2019/3/9 22:06
 */
public class IsPopOrder {
    Stack<Integer> stack = new Stack<>();

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
