package list;

public class AddTwoNumber {
	public static ListNode addTwoNumber(ListNode l1, ListNode l2){
		// method 1
		/*ListNode sentinel = new ListNode(0);
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
		if(sum / 10 == 1){
			d.next = new ListNode(1);
		}
		return sentinel.next;*/
		
		ListNode result = new ListNode(0);
		ListNode temp = result;
		int sum = 0;
		while(l1 != null || l2 != null){
			sum /= 10;
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			temp.setValue(sum % 10);
			temp = temp.next;
		}
		return result;
	}
	private static void printList(ListNode list) {
		if (list == null || list.getNext() == null) {
			System.err.println("The Link is null or empty!");
			return;
		}
		StringBuffer sb = new StringBuffer();
		ListNode temp = list;
		sb.append(temp.getValue());
		while (temp.getNext() != null) {
			sb.append("->");
			sb.append(temp.getNext().getValue());
			temp = temp.getNext();
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		int i = 2;
		ListNode n1 = new ListNode(2);
		ListNode temp = n1;
		while(i <= 3){
			ListNode node;
			if(i == 2){
				node = new ListNode(4);
			}else{
				node = new ListNode(3);
			}
			temp.setNext(node);
			temp = node;
			i++;
		}
		temp.setNext(null);
		ListNode n2 = new ListNode(5);
		ListNode temp2 = n2;
		int j = 2;
		while(j <= 3){
			ListNode node;
			if(j == 2){
				node = new ListNode(6);
			}else{
				node = new ListNode(4);
			}
			temp2.setNext(node);
			temp2 = node;
			j++;
		}
		temp2.setNext(null);
		ListNode resul = addTwoNumber(n1,n2);
		printList(resul);
	}
}
