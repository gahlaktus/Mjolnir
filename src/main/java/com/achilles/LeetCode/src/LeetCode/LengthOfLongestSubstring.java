package LeetCode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String str){
		 if (str.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<str.length(); ++i){
	            if (map.containsKey(str.charAt(i))){
	                j = Math.max(j,map.get(str.charAt(i))+1);
	            }
	            map.put(str.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	}
	
	public static void main(String[] args) {
		String str = "pwwkee"; 
		System.out.println(lengthOfLongestSubstring(str));
	}
}
