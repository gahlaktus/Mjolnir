package query;

public class FindMedian {
	public double findMedianSortedArrays(int[] a, int[] b){
		int ai = a.length;
		int bi = b.length;
		int k = (ai + bi - 1) / 2;
		int l = 0;
		int r = Math.min(k, ai);
		while( l < r){
			int midA = (l+r) / 2;
			int midB = k - midA;
			if(a[midA] < b[midB]){
				l=midA+1;
			}
			else{
				r = midA;
			}
		}
		int x = Math.max((l>0)?a[l-1]:Integer.MIN_VALUE, (k-l >= 0)?b[k-l]:Integer.MIN_VALUE);
		if(((ai+bi) & 1) == 1){
			return (double) x;
		}
		int y = Math.min(l < ai ? a[l]:Integer.MAX_VALUE, k-l < bi ? b[k-l+1]:Integer.MAX_VALUE );
		return (x+y)/2.0;
	}
}
