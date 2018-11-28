package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 01/03/2018
 */
public class LowercaseToUppercase {

    public char lowercaseToUppercase(char character) {
        int temp = (int) character;
        temp -= 32;
        return (char)(temp);
    }


    public static void main(String[] args) {
        LowercaseToUppercase lowercaseToUppercase = new LowercaseToUppercase();
        System.out.println(lowercaseToUppercase.lowercaseToUppercase('a'));

    }

}
