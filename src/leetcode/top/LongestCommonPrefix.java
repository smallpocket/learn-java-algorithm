package leetcode.top;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @author Heper
 * @title 最长公共前缀
 * @date 2019/4/3 22:48
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0 || strs[0].length() == 0) {
            return sb.toString();
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (i < s.length() && c == s.charAt(i)) {
                    continue;
                } else {
                    c = ' ';
                }
            }
            if (c != ' ') {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 水平扫描法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefixI(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //首先对于该字符串数组，如果只有一个字符串
        //那么该字符串就是最长公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //在下一个字符串中寻找前缀的index
            while (strs[i].indexOf(prefix) != 0) {
                //获取原最长子序列的子串
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 扫描字符串的列，所有字符串的第一列相等，则继续
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefixII(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
