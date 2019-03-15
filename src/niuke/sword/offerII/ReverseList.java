package niuke.sword.offerII;

/**
 * @author Heper
 * @title
 * @date 2019/3/9 21:50
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode temp;
        head.next = null;
        while (newHead != null) {
            temp = newHead.next;
            newHead.next = head;
            head = newHead;
            newHead = temp;
        }
        return head;
    }
    //TODO:递归法求解
//    ListNode* ReverseList(ListNode* pHead) {
//        //如果链表为空或者链表中只有一个元素
//        if(pHead==NULL||pHead->next==NULL) return pHead;
//
//        //先反转后面的链表，走到链表的末端结点
//        ListNode* pReverseNode=ReverseList(pHead->next);
//
//        //再将当前节点设置为后面节点的后续节点
//        pHead->next->next=pHead;
//        pHead->next=NULL;
//
//        return pReverseNode;
//
//    }
}
