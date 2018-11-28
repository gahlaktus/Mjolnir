package com.mjolnir.interview.lintcode.list;

import com.mjolnir.interview.lintcode.list.ListNode;

/**
 * @author huangzhibo
 * @date 01/03/2018
 */
public class CountListNodes {

    public int countNodes(ListNode head) {
        if (head == null){
            return 0;
        }
        if (head.next == null){
            return 1;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count ++;
            cur = cur.next;
        }
        return count;
    }

}
