package LeetCode.string;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseInteger {
	//my way
	public static int reverse(int x) {
		int reInt = 0, k = 0;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		if (x == 0 || x == Integer.MIN_VALUE)
			return 0;
		while (Math.abs(x) >= 10) {
			k = x % 10;
			queue.offer(k);
			x = x / 10;
		}
		queue.offer(x);
		while (!queue.isEmpty()) {
			reInt = reInt * 10 + queue.poll();
			System.out.println(reInt);
			if (!queue.isEmpty()) {
				if (Integer.MAX_VALUE / 10 < reInt
						|| Integer.MAX_VALUE / 10 == reInt && !queue.isEmpty()
								&& Integer.MAX_VALUE % 10 < queue.peek()
						|| Integer.MIN_VALUE / 10 > reInt
						|| Integer.MIN_VALUE / 10 == reInt && !queue.isEmpty()
								&& Integer.MIN_VALUE % 10 > queue.peek()) {
					reInt = 0;
					break;
				/*} else if (Integer.MAX_VALUE / 10 == reInt && !queue.isEmpty()
						&& Integer.MAX_VALUE % 10 < queue.peek()) {
					reInt = 0;
					break;
				} else if (Integer.MIN_VALUE / 10 > reInt) {
					reInt = 0;
					break;
				} else if (Integer.MIN_VALUE / 10 == reInt && !queue.isEmpty()
						&& Integer.MIN_VALUE % 10 > queue.peek()) {
					reInt = 0;
					break;*/
				}
			}
		}
		return reInt;
		
		// ²Î¿¼
		/*int result = 0;
	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }
	    return result;*/
	}

	public static void main(String[] args) {
		int test = -2147483648;
		System.out.println(reverse(test));
		System.out.println("Integer.MIN_VALUE : " + Integer.MIN_VALUE); // -2147483648
		System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE); // 2147483647
	}
}
