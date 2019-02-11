package niuke.sword.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @Title : 用两个栈实现队列
 * @Author : Heper
 * @Time : 2019/2/10 14:39
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 添加
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 获得并删除
     *
     * @return
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int first = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }
}
