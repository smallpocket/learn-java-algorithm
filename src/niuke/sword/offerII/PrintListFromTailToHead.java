package niuke.sword.offerII;

import java.util.ArrayList;

/**
 * @author Heper
 * @title
 * @date 2019/3/8 20:13
 */
public class PrintListFromTailToHead {
    private ArrayList<Integer> res = new ArrayList<>();

    /**
     * 递归的做法
     * 个人感觉逆序也可以
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return res;
        }
        printListFromTailToHead(listNode.next);
        res.add(listNode.val);
        return res;
    }
}
