package leetcode.top;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，
 * 那么原来的键值对将被替代成新的键值对。
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 * @author Heper
 * @title 键值映射
 * @date 2019/2/19 16:16
 */
public class MapSum {
    public class Node {
        Node[] leaf = new Node[26];
        int val;
    }

    private Node root = new Node();

    /**
     * Initialize your data structure here.
     */
    public MapSum() {

    }

    public void insert(String key, int val) {
        insert(key, val, root);
    }

    public void insert(String key, int val, Node root) {
        if (root == null) {
            return;
        }
        if (key.length() == 0) {
            root.val = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (root.leaf[index] == null) {
            root.leaf[index] = new Node();
        }
        insert(key.substring(1), val, root.leaf[index]);
    }

    public int sum(String prefix) {
        return sum(prefix, root);
    }

    public int sum(String prefix, Node root) {
        if (root == null) {
            return 0;
        }
        if (prefix.length() == 0) {
            int sum = root.val;
            for (Node node : root.leaf) {
                sum += sum(prefix, node);
            }
            return sum;
        }
        int index = indexForChar(prefix.charAt(0));
        return sum(prefix.substring(1), root.leaf[index]);
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
