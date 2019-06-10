package leetcode.top;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * @author Heper
 * @title 反转字符串中的元音字母
 * @date 2019/4/2 23:10
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int floor = 0, top = s.length() - 1;
        while (floor < top) {
            while (!ifVowel(cs[floor])) {
                floor++;
                if (floor >= s.length()) {
                    break;
                }
            }
            while (!ifVowel(cs[top])) {
                top--;
                if (top < 0) {
                    break;
                }
            }
            if (top > floor) {
                swap(cs, floor++, top--);
            }
        }
        return new String(cs);
    }

    public boolean ifVowel(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c;
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        new ReverseVowels().reverseVowels("hello");
    }
}

