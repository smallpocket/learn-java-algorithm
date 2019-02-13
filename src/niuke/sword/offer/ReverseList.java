package niuke.sword.offer;

/**
 * @author Heper
 * @title
 * @date 2019/2/13 19:26
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                newHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return newHead;
    }
}
