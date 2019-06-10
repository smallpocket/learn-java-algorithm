package leetcode.top;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Heper
 * @title 无重复字符的最长子串
 * @date 2019/2/13 23:25
 */
public class LengthOfLongestSubstring {
    /**
     * 是否重复的检验方法：
     * 1. 用一个26位的数组,出现a就给数组0位+1,依次来判断是否有该字符
     * 2. 用set检验
     * <p>
     * 滑动窗口算法：计算最长子串的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        Set<Character> set = new HashSet<>();
        //ans记录无重复字符的最长子串
        //i记录子串开头,j记录结尾
        int ans = 0, i = 0, j = 0;
        //滑动窗口算法，窗口为[i,j]
        while (i < n && j < n) {
            //查询当前的窗口当中是否存在j
            //如果存在就添加并令j++，即右侧窗右移
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                //遇到重复的字符，将左侧的窗口右移动
                //此时可知在[i+1,j-1]区间内是无重复的。因此直接判断在[i+1,j]中j的加入是否影响
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 继续做优化，在上次的算法当中，需要在左侧窗口不断的右推，如果直接知道j字符所出现的位置，
     * 令i等于位置+1即可
     * 方式：
     * 1. hashmap
     * 2. 数组
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringI(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length(), ans = 0;
        //字符，字符出现的index
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            //原有的值被覆盖了。
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
