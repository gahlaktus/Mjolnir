package com.mjolnir.interview.lintcode;

/**
 * 8. 旋转字符串
 *
 * @author huangzhibo
 * @date 05/03/2018
 */
public class RotateString {

    /**
     * @param str:    An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {

        if (str == null || str.length == 0) {
            return;
        }

        int real_offset = offset % str.length;

        char[] tempArr = new char[str.length * 2];

        int k = 2, j = 0;

        while (k > 0) {

            for (int i = 0; i < str.length; i++) {
                tempArr[j++] = str[i];
            }

            k--;
        }

        int pivot = str.length - real_offset;
        int i = pivot, kp = 0;
        while (kp < str.length) {
            str[kp] = tempArr[i];
            kp++;
            i = pivot + kp;
        }

    }

    public void rotateString1(char[] str, int offset) {

        if (str == null || str.length == 0) {
            return;
        }

        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);

    }

    public void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    /**
     * 用直接定位法，来进行每个字符的定位。可以理解城对号入座，只需要进行n-1次就可以了。
     * @param str
     * @param offset
     */
    public void rotateString2(char[] str, int offset) {

        if (str == null || str.length == 0) {
            return;
        }
        int now = 0;
        int last = 0;
        char tempStr;
        offset = offset % str.length;
        if (offset != 0) {
            for (int i = 1; i < str.length; i++) {
                tempStr = str[Math.abs((offset + now) % str.length)];
                str[Math.abs((now + offset) % str.length)] = str[last];
                str[last] = tempStr;
                now = Math.abs((offset + now) % str.length);
                if (now == last) {
                    last++;
                    now = last;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        char[] test = str.toCharArray();
        for (char ch : test) {
            System.out.println(ch);
        }
        System.out.println("----------------");
        RotateString rotateString = new RotateString();
        rotateString.rotateString2(test, 6);
        for (char ch : test) {
            System.out.println(ch);
        }
    }

}
