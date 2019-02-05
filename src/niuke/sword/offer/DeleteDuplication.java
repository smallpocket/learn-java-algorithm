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

    /**
     * FIXME:断链,断开next的引用即可
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead) {

        if (pHead == null) {
            return null;
        }
        ListNode p = pHead;
        ListNode n = new ListNode(0);
        ListNode pre = n;
        n.next = pHead;
        boolean flag = false;
        while (p != null) {
            ListNode q = p.next;
            if (q == null) {
                break;
            }
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
            } else {
                if (!flag) {
                    n.next = p;
                    flag = true;
                }
                pre = p;
                p = q;
            }
        }
        return n.next;
    }

    /**
     * 使用递归
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication3(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
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
