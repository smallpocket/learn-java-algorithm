package leetcode.explore.data.sturcture;

import java.util.Stack;

/**
 * @author Heper
 * @title
 * @date 2019/2/14 21:40
 */
public class MinStack {
    /**
     * FIXME:非常巧妙的设计
     * 题目要求是设计一个栈，用两个栈能解决问题，但就是投机取巧了哈哈。
     * 思路：每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值
     * 如：入栈序列为2-3-1，则入栈后栈中元素序列为：2-2-3-2-1-1
     * 用空间代价来换取时间代价
     */
    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }

    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
