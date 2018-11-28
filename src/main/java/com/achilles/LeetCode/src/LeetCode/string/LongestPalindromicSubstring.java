package LeetCode.string;

/**
 * 最长回文子串 Given a string S, find the longest palindromic substring in S. You may
 * assume that the maximum length of S is 1000, and there exists one unique
 * longest palindromic substring.
 *
 * @author huang 方法：暴力法、dp、中心扩展法、manacher算法
 */
public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		StringBuffer reSb = new StringBuffer();
		char[] a = s.toCharArray();
		int[] pos = new int[2];
		int cur = 0, len = a.length, i = 1;
		while (cur < len) {
			while(cur+i < len && (cur-i-1 >=0) && (a[cur-i-1] == a[cur+i])){
				if(2*i > pos[1]){
					pos[0] = cur;
					pos[1] = 2*i;
				}
				i++;
			}
			i = 1;
			while (cur - i >= 0 && cur + i < len) {
				if (a[cur - i] == a[cur + i]) {
					if (2*i+1 > pos[1]) {
						pos[0] = cur;
						pos[1] = 2*i+1;
					}
					i++;
				}
				else{
					break;
				}
			}
			
			i = 1;
			cur++;
		}
		System.out.println(pos[0]+" "+pos[1]);
		int offset;
		if((pos[0] & 1) == 1){
			offset = (pos[1]-1) / 2;
		}else{
			offset = pos[1] / 2;
		}
		for (int j = pos[0] - offset; j <= pos[0] + offset; j++)
			reSb.append(a[j]);
		return reSb.toString();
	}

	public static void main(String[] args) {
		String str = "skdmadmmdamuvw";
		System.out.println(longestPalindrome(str));
	}
}
