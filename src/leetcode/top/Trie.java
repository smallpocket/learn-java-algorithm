package leetcode.top;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * <p>
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * @author Heper
 * @title 实现 Trie (前缀树)
 * @date 2019/2/19 16:10
 */
public class Trie {
    /**
     * 键或者叶子
     */
    private class Node {
        //存放节点
        Node[] childs = new Node[26];
        //是否是叶子结点
        boolean isLeaf;
    }

    /**
     * 根节点
     */
    private Node root = new Node();

    public Trie() {
    }

    /**
     * 插入一个单词进入trie树
     *
     * @param word
     */
    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(word.substring(1), node.childs[index]);
    }

    /**
     * 查找是否有word单词
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.childs[index]);
    }

    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }

    /**
     * 是否有以该子串开头的单词
     *
     * @param prefix
     * @param node
     * @return
     */
    private boolean startWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }

    /**
     * 查找字母位次
     *
     * @param c
     * @return
     */
    private int indexForChar(char c) {
        return c - 'a';
    }
}
