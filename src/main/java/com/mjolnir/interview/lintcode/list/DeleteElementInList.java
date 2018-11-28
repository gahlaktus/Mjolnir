package com.mjolnir.interview.lintcode.list;

/**
 * @author huangzhibo
 * @date 26/02/2018
 */
public class DeleteElementInList {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null){
            return null;
        }
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode != null){
            if (curNode.val == val){
                curNode = curNode.next;
            }
            else {
                preNode.next = curNode;
                preNode = curNode;
                curNode = preNode.next;
            }

        }
        preNode.next = null;
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {

        if (head == null){
            return null;
        }
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode != null){
            if (curNode.val == val){
                preNode.next = curNode.next;
                curNode = curNode.next;
            }
            else {
                preNode = preNode.next;
                curNode = curNode.next;
            }

        }
        if (head.val == val){
            head = head.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;

        while (head.next != null){
            if (head.next.val == val){
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        return dummyNode.next;
    }

}
