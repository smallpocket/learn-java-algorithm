package niuke.sword.offer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @Title : 从尾到头打印链表
 * @Author : Heper
 * @Time : 2019/2/10 13:07
 */
public class PrintListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    private ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }
}
