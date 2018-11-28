package LeetCode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 * @author huang
 *
 */
public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		//method one: use PriorityQueue(heap)
		if(lists == null || lists.length == 0) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val < o2.val)
					return -1;
				else if(o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		for (ListNode node : lists) {
			if(node != null)
				queue.add(node);
		}
		
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			//?
			if(tail.next != null){
				queue.add(tail.next);
			}
		}
		return dummy.next;
	}
	
	//method two
	/*public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);
		if (lists.size() == 2)
			return mergeTwoLists(lists.get(0), lists.get(1));
		//ตÝน้
		return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
				mergeKLists(lists.subList(lists.size()/2, lists.size())));
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode head = null;
		ListNode former = null;
		while(l1 != null && l2 != null){
			if(l1.val > l2.val){
				if(former==null) former=l2;
				else former.next=l2;
				if(head==null) head=former;
				else former = former.next;
				l2=l2.next;
			}else{
				if(former==null) former=l1;else former.next=l1;
				if(head==null) head=former; else former=former.next;
				l1=l1.next;
			}
		}
		if(l2 != null) l1 = l2;
		former.next=l1;
		return head;
	}*/
}
