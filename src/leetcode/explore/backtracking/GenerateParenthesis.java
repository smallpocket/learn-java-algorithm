package leetcode.explore.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author Heper
 * @title 生成括号
 * @date 2019/2/11 22:51
 */
public class GenerateParenthesis {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return list;
        }
        add(0, 0, n, "");
        return list;
    }

    /**
     * @param open  开口括号的数目
     * @param close 闭口括号的数目
     * @param n     括号数目
     * @param str   生成的字符串
     */
    public void add(int open, int close, int n, String str) {
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }
        if (open < n) {
            add(open + 1, close, n, str + "(");
        }
        if (close < open) {
            add(open, close + 1, n, str + ")");
        }
    }
}
