package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和
 * 写入数据 put 。获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删
 * 除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * LRUCache cache = new LRUCache( 2  缓存容量  );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * @author Heper
 * @title LRU缓存机制
 * @date 2019/2/14 18:55
 */

public class LRUCache {

    private LRU cache;

    public LRUCache(int capacity) {
        cache = new LRU(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    class LRU extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRU(int capacity) {
            // 注意，需要开启 ordering mode，此时若元素被访问（put、get）就会被移到链表尾
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        /**
         * removeEldestE***y 方法会在插入元素之后调用，用以判断是否需要移除链表表头元素（最近最少访问元素）
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}

class LRUCache2 {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> map = new HashMap<>();

    int size = 0;
    Node dummy = new Node();
    Node tail = new Node();
    int capa;

    public LRUCache2(int capacity) {
        capa = capacity;
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node i = map.get(key);
        Node tempPrev = i.prev;
        Node tempNext = i.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
        Node tempTailPrev = tail.prev;
        tempTailPrev.next = i;
        i.prev = tempTailPrev;
        i.next = tail;
        tail.prev = i;
        return i.value;

    }

//     private moveNodetoTail (Node cur) {

//     }

    public void put(int key, int value) {
        Node i = map.get(key);
        if (i == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            if (size >= capa) {
                Node tempHead = dummy.next;
                dummy.next = tempHead.next;
                dummy.next.prev = dummy;
                map.remove(tempHead.key);
            }
            map.put(key, newNode);
            Node tempTailPrev = tail.prev;
            tempTailPrev.next = newNode;
            newNode.prev = tempTailPrev;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        } else {
            i.value = value;
            Node tempPrev = i.prev;
            Node tempNext = i.next;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;

            Node tempTailPrev = tail.prev;
            tempTailPrev.next = i;
            i.prev = tempTailPrev;
            i.next = tail;
            tail.prev = i;
        }
    }
}
