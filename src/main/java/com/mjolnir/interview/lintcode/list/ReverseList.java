package com.mjolnir.interview.lintcode.list;

/**
 * @author huangzhibo
 * @date 23/03/2018
 */
public class ReverseList {

    public ListNode reverse(ListNode head) {
        // write your code here

        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        cur.next = null;
        while (next != null){
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }

}
