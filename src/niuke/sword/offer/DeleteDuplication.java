package niuke.sword.offer;

/**
 * 删除链表当中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @Author : Heper
 * @Time : 2019/2/4 18:13
 */
public class DeleteDuplication {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || (pHead.next == null)) {
            return pHead;
        }
        ListNode pre = pHead;
        ListNode temp = pHead.next;
        do {
            if (temp.val == pre.val) {
                pre.next = temp.next.next;
                pre.val = temp.next.val;
                if (pre == pHead) {
                    pHead = pre;
                }
                if (pre.next != null) {
                    temp.next = pre.next.next;
                    temp.val = pre.next.val;
                }
            } else {
                pre = temp;
                temp = temp.next;
            }
        } while (temp != null);
        return pHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head = DeleteDuplication.deleteDuplication(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;

        }

    }
}
