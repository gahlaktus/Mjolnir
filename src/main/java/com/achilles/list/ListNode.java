package list;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
	public void setNext(ListNode next){
		this.next = next;
	}
	public ListNode getNext() {
		return next;
	}
	public void setValue(int val){
		this.val = val;
	}
	public int getValue() {
		return val;
	}
}
