package LeetCode;
//链表
public class AddTwoNumber {
	public static ListNode addTwoNumber(ListNode l1, ListNode l2){
		ListNode sentinel = new ListNode(0);
		ListNode ln1 = l1;
		ListNode ln2 = l2;
		ListNode d = sentinel;
		int sum = 0;
		while(ln1 != null || ln2 != null){
			sum /= 10;
			if(ln1 != null){
				sum += ln1.val;
				ln1 = ln1.next;
			}
			if(ln2 != null){
				sum += ln2.val;
				ln2 = ln2.next;
			}
			d.next = new ListNode(sum % 10);
			d = d.next;
		}
		//最高位相加，结果进1
		if(sum / 10 == 1){
			d.next = new ListNode(1);
		}
		return sentinel.next;
	}
}
