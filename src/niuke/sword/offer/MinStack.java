package niuke.sword.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author Heper
 * @title 包含min函数的栈
 * @date 2019/2/13 19:59
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();

    /**
     * 辅助栈,只保存当前最小值
     */
    Stack<Integer> stack1 = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (stack1.empty()) {
            stack1.push(node);
        }
        int s = stack1.peek();
        if (s >= node) {
            stack1.push(node);
        }
    }

    public void pop() {
        int s1 = stack1.peek();
        int s2 = stack.peek();
        if (s1 == s2) {
            stack1.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack1.peek();
    }
}
