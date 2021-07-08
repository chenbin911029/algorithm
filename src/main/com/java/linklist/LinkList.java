package main.com.java.linklist;

/**
 * 链表
 */
public class LinkList {

    class ListNode {
        int val;
        ListNode next;
    }

    void linkListTraverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println("ListNode.val=" + p.val);
        }
    }

    void depthTraverse(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println("ListNode depth traverse val = " + head.val);
        depthTraverse(head.next);
    }

}
