package leetcode.top;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author Heper
 * @title 删除链表的倒数第N个节点
 * @date 2019/2/18 15:01
 */
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode s1 = head, s2 = head;
        for (int i = 0; i < n; i++) {
            s1 = s1.next;
        }
        while (s1.next != null) {
            s1 = s1.next;
            s2 = s2.next;
        }
        s2.next = s2.next.next;
        return head;
    }
}
