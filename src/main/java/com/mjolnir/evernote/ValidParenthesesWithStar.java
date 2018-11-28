package com.mjolnir.evernote;

/**
 * @author huangzhibo
 * @date 2018/9/20
 */
public class ValidParenthesesWithStar {


    public static boolean validParenthesesWithStar(String str){

        if (str == null || "".equals(str)){
            return false;
        }

        int len = str.length();
        int l = 0, cp = 0;
        for (int i = 0; i < len; i++) {

            char cha = str.charAt(i);

            if ('(' == cha){
                l++;
                cp++;
            } else if ('*' == cha){
                if (l > 0){
                    l--;
                }
                cp++;
            }else {
                if (l > 0){
                    l--;
                }
                cp--;
                if (cp < 0){
                    return false;
                }
            }
        }
        if (l == 0){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        String str = "(*)*))*(*))()";
        System.out.println(validParenthesesWithStar(str));
    }

}
