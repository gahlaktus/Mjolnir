package prepare;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		Queue<Integer> qu = new PriorityQueue<Integer>();
		
		qu.add(5);
		qu.add(2);
		qu.add(1);
		qu.add(10);
		qu.add(3);
		
		while(!qu.isEmpty()){
			System.out.println(qu.poll() + ",");
		}
		System.out.println("-----------------------------------------");
		Comparator<Integer> cmp = new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		};
		Queue<Integer> qu2 = new PriorityQueue<Integer>(5, cmp);
		qu2.add(2);
		qu2.add(8);
		qu2.add(9);
		qu2.add(1);
		while(!qu2.isEmpty()){
			System.out.println(qu2.poll() + ",");
		}
	}
}
