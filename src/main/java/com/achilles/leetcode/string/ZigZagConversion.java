package LeetCode.string;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
	/*	StringBuilder reSb = new StringBuilder();
		if (s.length() == 0)
			return null;
		int numCols = 0;
		if (s.length() % numRows != 0) {
			numCols = (s.length() / (numRows * 2 - 2)) * 2 + 1;
		} else {
			numCols = (s.length() / (numRows * 2 - 2)) * 2;
		}
		char[][] mStr = new char[numRows][numCols];
		int k = 0, temp,i = 0;
		for (int j = 0; j < numCols; j++) { // col
			if ((j & 1) == 1) {
				temp = numRows - 1;
				k += 1;
			} else {
				temp = numRows;
			}
			while( i < s.length() && k < temp) {// s
					mStr[k][j] = s.charAt(i);
					k++;
					i++;
				}
			k = 0;
		}
		for (char[] cs : mStr) {
			for (char c : cs) {
				if(c != 0)
					reSb.append(c);
			}
		}
		return reSb.toString();*/
		
		//参考方法
		/*char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int j = 0; j < sb.length; j++) {
			sb[j] = new StringBuffer();
		}
		int i = 0;
		while(i < len){
			for (int idx = 0; idx < numRows && i < len; idx++) {
				sb[idx].append(c[i++]);
			}
			for (int idx = numRows-2; idx >= 1 && i < len; idx--) {
				sb[idx].append(c[i++]);
			}
		}
		for (int idx = 0; idx < sb.length; idx++) {
			sb[0].append(sb[idx]);
		}
		return sb[0].toString();*/
		/**
		 * 思路：将每一行看做一个StringBuffer，切勿采用二维数组，维度较高且不易操作。
		 * 此外就是要考虑斜线上面的字符如何准确赋值。  up-down
		 */
		int len = s.length(), index = 0;
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuffer();
		}
		while(index < len){
			for (int j = 0; j < sb.length && index < len; j++)
				sb[j].append(s.charAt(index++));
			for (int k = numRows-2; k >= 1 && index < len; k--)
				sb[k].append(s.charAt(index++));
		}
		for (int i = 1; i < sb.length; i++) {
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
	}

	public static void main(String[] args) {
		String str = "ab";
		System.out.println(convert(str, 1));
	}
}
