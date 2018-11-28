package prepare;

class Node{
	String val;
	Node next;
	public Node(String x){val = x;}
	public Node get(){return this;}
	public void set(Node node){
		;
	}
	public boolean compareAndSwap(Node b, Node c) {
		// TODO Auto-generated method stub
		return false;
	}
}
public class AtomicListInsert {
	private void listInsert(Node head, Node c){
		for(;;){
			Node a = findInsertionPlace(head),b = a.next.get();
			c.next.set(b);
			if(a.next.compareAndSwap(b,c))
				return;
		}
	}

	private Node findInsertionPlace(Node head) {
		return null;
	}
}
