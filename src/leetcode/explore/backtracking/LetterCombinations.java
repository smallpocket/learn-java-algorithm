package leetcode.explore.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author Heper
 * @title 电话号码的字母组合
 * @date 2019/2/11 22:51
 */
public class LetterCombinations {
    List<String> list = new ArrayList<>();
    Map<Integer, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        //FIXME:使用一个二维char数组更好一些
        //charAt(j)可以获得一个字符串第j个位置的字母
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        int number = Integer.parseInt(digits);
        int[] num = new int[digits.length()];
        for (int i = digits.length() - 1; i > -1; i--) {
            num[i] = number % 10;
            number /= 10;
        }
        //FIXME:使用StringBuffer也可以,最后利用toString将字符串加入集合当中
        addLetter(0, num, "");
        return list;
    }

    /**
     * 回溯法重要的还是思路
     * 如何回溯,哪个节点回溯等
     *
     * @param letterIndex 字母的位置
     * @param letters     输入的数字数组
     * @param str         结合得到的字符串
     */
    public void addLetter(int letterIndex, int[] letters, String str) {
        if (letterIndex == letters.length) {
            return;
        }
        char[] word = map.get(letters[letterIndex]);
        for (int i = 0; i < word.length; i++) {
            addLetter(letterIndex + 1, letters, str + word[i]);
            if (letterIndex == letters.length - 1) {
                list.add(str + word[i]);
            }
        }
    }
}
