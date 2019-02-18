package niuke.sword.offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 *
 * @author Heper
 * @title 合并两个排序的链表
 * @date 2019/2/13 19:33
 */
public class Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode temp, temp2, head = list1;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp2 = list2.next;
                temp = list1.next;
                list1.next = list2;
                list2.next = temp;
                list2 = temp2;
                list1 = list1.next.next;
            }
        }
        //直接将剩下的拼接上去
        if (list2 != null) {
            list1.next = list2;
        }
        return head;
    }
}
