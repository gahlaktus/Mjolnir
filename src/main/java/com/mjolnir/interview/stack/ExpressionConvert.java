package com.mjolnir.interview.stack;

import java.util.Stack;

/**
 * 中缀表达式转换为后缀表达式
 * eg:  a+b*c+(d*e+f)*g  => abc*+de*f+g*+
 * @author huangzhibo
 * @date 28/03/2018
 */
public class ExpressionConvert {

    public String convert(String exp){

        System.out.println("转换前："+exp);

        char[] expArr = exp.toCharArray();

        Stack<Character> tempStack = new Stack<>();
        StringBuilder sb = new StringBuilder(expArr.length);
        boolean closeOper = false;

        for (char cha : expArr){

            if (cha == '+' || cha == '-'){
                while (!tempStack.isEmpty() && (tempStack.peek() != '(')){
                    sb.append(tempStack.pop());
                }
                tempStack.push(cha);
            }
            else if (cha == '*' || cha == '/'){
                boolean pushFlag = !tempStack.isEmpty() && (tempStack.peek() == '+' || tempStack.peek() == '-');
                if (closeOper || pushFlag){
                    tempStack.push(cha);
                }
                else {
                    sb.append(cha);
                }
            }
            else if (cha == '('){
                tempStack.push(cha);
                closeOper = true;
            }
            else if (cha == ')'){
                while (!tempStack.isEmpty() && tempStack.peek() != '('){
                    sb.append(tempStack.pop());
                }
                tempStack.pop();
                closeOper = false;
            }
            else {
                sb.append(cha);
            }

        }

        while (!tempStack.isEmpty()){
            sb.append(tempStack.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String str = "a+b*c+(d*e+f)*g";
        ExpressionConvert convert = new ExpressionConvert();
        System.out.println("转换后："+convert.convert(str));
    }

}
