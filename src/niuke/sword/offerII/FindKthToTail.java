package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/9 21:48
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode s1 = head, s2 = head;
        int index = 0;
        while (s1 != null) {
            s1 = s1.next;
            if (index < k) {
                index++;
            } else {
                s2 = s2.next;
            }
        }
        return s2;
    }
}
