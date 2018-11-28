package com.mjolnir.interview.stack;

/**
 * 描述：
 * 给定一个字符串，由（  *  ）三个字符组成，判断是否满足要求左括号和有括号一一对应，且对应的左括号必定在右括号前面。
 * 其中，*可以被当做一个单独的左括号，右括号或者可以当做不存在。
 * 样例：
 *  1. Input: "()"            Output: True
    2. Input: "(*)"          Output: True      //*被当做空字符，不存在
    3. Input: "(*))"         Output: True     //星号被当做左括号
 * @author huangzhibo
 * @date 29/03/2018
 */
public class Packet {


    public boolean checkValidString (String str){
        int len = str.length();
        int l=0, cp=0;
        char[] chaArr = str.toCharArray();
        for (int i = 0; i < len; i++) {

            if (chaArr[i] == '('){
                l++;
                cp++;
            }
            else if (chaArr[i] == '*'){
                if (l > 0){
                    l--;
                }
                cp++;
            }
            else {
                if (l > 0){
                    l--;
                }
                cp--;
                if (cp < 0){
                    return false;
                }
            }

        }
        return l == 0;
    }

    public boolean checkValidString1 (String str){
        int len = str.length();
        int l=0, cp=0;
        for (int i = 0; i < len; i++) {

            if (str.charAt(i) == '('){
                l++;
                cp++;
            }
            else if (str.charAt(i) == '*'){
                if (l > 0){
                    l--;
                }
                cp++;
            }
            else {
                if (l > 0){
                    l--;
                }
                cp--;
                if (cp < 0){
                    return false;
                }
            }

        }
        return l == 0;
    }


    public static void main(String[] args) {
        String t = "(*))";
        Packet packet = new Packet();
        System.out.println(packet.checkValidString1(t));
    }

}
