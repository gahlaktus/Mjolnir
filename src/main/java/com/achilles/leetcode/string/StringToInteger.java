package LeetCode.string;
/**
 * ����ʵ�� Stringת����Integer
 * �ο�Integer.parseInt(String s, int radix);
 * @author huang
 *
 */
/**
 * 1.�ж�string�����Ƿ�Ϊ0��
 * 2.ȥ���ո����
 * 3.�����ж�
 * 4.������������ж�
 *
 */
public class StringToInteger {
	public int myAtoi(String str) {
	        int intVal = 0, sign = 1, index = 0;
			//1. Empty string
			if(str.length() == 0) return 0;
			//2. Remove Spaces
			while(str.charAt(index) == ' ' && index < str.length())
				index ++;
			
			//3. Handle signs
			if(str.charAt(index) == '+' || str.charAt(index) == '-'){
				sign = str.charAt(index) == '+' ? 1 : -1;
				index ++;
			}
			
			//4. Convert number and avoid overflow
			while(index < str.length()){
				int digit = str.charAt(index) - '0';
				if(digit < 0 || digit > 9) break;
				
				//check if intVal will be overflow after 10 times and add digit
				if(Integer.MAX_VALUE / 10 < intVal || 
						Integer.MAX_VALUE / 10 == intVal && Integer.MAX_VALUE % 10 < digit){
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				intVal = 10 * intVal + digit;
				index ++;
			}
			return intVal * sign;
	}
}
