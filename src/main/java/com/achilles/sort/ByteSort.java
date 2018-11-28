package sort;
/**
 * 1.Î»Í¼
 * 2.¶àÌËËã·¨
 * @author huang
 *
 */
public class ByteSort {
	static final int SHIFT = 5;
	static final long MASK = 0x1FL;
	static final int N = 10000000;
	static int[] a = new int[1 + N/32];
	static void set(int i){
		a[i>>SHIFT] |= (1<<(i & MASK));
	}
	static void clr(int i){
		a[i>>SHIFT] &= ~(1<<(i & MASK));
	}
	static int test(int i){
		return a[i>>SHIFT] & (1<<(i & MASK));
	}
	public static void main(String[] args) {
		int i = 0;
		while(System.in != null){
			set(i);
		}
		for (int j = 0; j < N; j++) {
			test(i);
			System.out.println(i);
		}
	}
}
