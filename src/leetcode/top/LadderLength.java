package leetcode.top;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * @author Heper
 * @title 单词接龙
 * @date 2019/2/17 14:26
 */
public class LadderLength {
    /**
     * BFS解决
     * 同时也可以两端搜索,使得两边碰面即可
     *
     * @param beginWord 初始单词
     * @param endWord   待转换单词
     * @param wordList  字典
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Stack<String> ladders = new Stack<>();
        ladders.push(beginWord);
        boolean[] ifExist = new boolean[wordList.size()];
        int level = 1;
        //只要栈非空
        while (!ladders.empty()) {
            int size = ladders.size();
            level++;
            while (size > 0) {
                String temp = ladders.pop();
                for (int i = 0; i < wordList.size(); i++) {
                    //这个单词未被访问,且与原单词只有一个单词不相同
                    if (!ifExist[i] && ifLad(temp, wordList.get(i))) {
                        if (wordList.get(i).equals(endWord)) {
                            return level;
                        }
                        ladders.push(wordList.get(i));
                        ifExist[i] = true;
                    }
                }
                size--;
            }
        }
        return 0;
    }

    /**
     * 判断是否能够转换
     *
     * @param beginWord
     * @param endWord
     * @return
     */
    public boolean ifLad(String beginWord, String endWord) {
        int len = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) {
                len++;
            }
        }
        if (len < 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        LadderLength ladderLength = new LadderLength();
        ladderLength.ladderLength("hit", "cog", wordList);
    }

}
