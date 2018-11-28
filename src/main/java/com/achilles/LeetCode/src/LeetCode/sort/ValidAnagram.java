package LeetCode.sort;

import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
	 /*public static boolean isAnagram(String s, String t) {
	        if(s.length() != t.length()) return false;
	        char[] ss = new char[s.length()];
			char[] tt = new char[t.length()];
			for (int i = 0; i < s.length(); i++) {
				ss[i] = s.charAt(i); 
				tt[i] = t.charAt(i);
			}
			Arrays.sort(ss);
			Arrays.sort(tt);
			for (int i = 0; i < tt.length; i++) {
				if(ss[i] != tt[i]) return false;
			}
			return true;
	    }*/
	 
	 //brilliant 如果只是字母这样很不错，思路挺酷的。
	 /*public boolean isAnagram(String s, String t) {
	        int[] alphabet = new int[26];
	        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
	        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
	        for (int i : alphabet) if (i != 0) return false;
	        return true;
	    }*/
	 
	 public static boolean isAnagram(String s, String t) {
         if (s.length()!=t.length()) return false;
         int[] c=new int[256];
         for (int i=0; i<s.length(); ++i){
             c[s.charAt(i)]++; 
             c[t.charAt(i)]--;
         }

         for (int i=0; i<256; ++i){
             if (c[i]!=0) return false;
         }
         return true;
     }
	 public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s,t));
	}
}
