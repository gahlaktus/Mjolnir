package com.mjolnir.interview.array;

/**
 *
 * 两个大数相加
 * 1. 将两个大数先分别倒序写入两个数组，然后将两个数组相加得到一个新的数组，然后再倒序输出这个数组即可。
 * 2. 大致思路如上，只是分别9位分割大数字符串，Integer最长10位，这样可以防止溢出，然后再相加并输出结果。
 * 3. ASCII运算
 *
 * @author huangzhibo
 * @date 2018/12/17
 */
public class BigNumberSum {

    public static String bigNumberSum(String bigNumA, String bigNumB){

        int maxLen = bigNumA.length() > bigNumB.length() ? bigNumA.length() : bigNumB.length();

        int[] arrA = new int[maxLen + 1];

        for (int i = 0; i < bigNumA.length(); i++) {
            arrA[i] = bigNumA.charAt(bigNumA.length() - 1 -i) - '0';
        }

        int[] arrB = new int[maxLen + 1];
        for (int j = 0; j < bigNumB.length(); j++){
            arrB[j] = bigNumB.charAt(bigNumB.length()-1-j) - '0';
        }

        int[] result = new int[maxLen+1];

        for (int k=0; k < result.length; k++){
            int temp = result[k];
            temp += arrA[k];
            temp += arrB[k];

            if (temp >= 10){
                temp = temp - 10;
                result[k+1] = 1;
            }
            result[k] = temp;
        }

        StringBuilder sb = new StringBuilder();

        boolean findFirst = false;
        for (int t = result.length-1; t >= 0; t--){
            if (!findFirst){
                if (result[t] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[t]);
        }
        return sb.toString();

    }

    public static String sumBigNumber(String bigNumA, String bigNumB){

        int maxLen = bigNumA.length() > bigNumB.length() ? bigNumA.length() / 9 : bigNumB.length() / 9;

        int[] arrA = new int[maxLen + 1];
        int[] arrB = new int[maxLen + 1];
        int[] result = new int[maxLen+1];

        if (bigNumA.length() > 9){
            int k = bigNumA.length() / 9;
            int m = bigNumA.length() % 9;
            if (m == 0){
                for (int i = 0,j=i+9; i < bigNumA.length();) {
                    arrA[i] = Integer.parseInt(bigNumA.substring(i, j));
                    i = j;
                    j = i+9;
                }
            } else {



            }

        } else {
            arrA[0] = Integer.parseInt(bigNumA);
        }

        if (bigNumB.length() > 9){
            for (int i = 0,j=i+9; i < bigNumB.length();) {
                arrB[i] = Integer.parseInt(bigNumB.substring(i, j));
                i = j;
                j = i+9;
            }
        } else {
            arrB[0] = Integer.parseInt(bigNumB);
        }

        for (int k=0; k < result.length; k++){
            int temp = result[k];
            temp += arrA[k];
            temp += arrB[k];
            result[k] = temp;
        }

        StringBuilder sb = new StringBuilder();

        boolean findFirst = false;

        for (int t = result.length-1; t >= 0; t--){
            if (!findFirst){
                if (result[t] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[t]);
        }
        return sb.toString();
    }

    private static String add(String str1, String str2) {
        //任何一个字符串为null或空字符串，都不需要相加了
        if (str1 == null || "".equals(str1)) {
            return str2;
        }
        if (str2 == null || "".equals(str2)) {
            return str1;
        }
        int maxLength = Math.max(str1.length(), str2.length());
        //定义一个存贮结果的字符串，长度要比最大长度字符串还长一位，用于存储可能出现的进位
        StringBuffer result = new StringBuffer(maxLength + 1);

        //翻转两个字符串
        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();

        int minLength = Math.min(str1.length(), str2.length());
        //进位
        int carry = 0;
        //当前位上的数值
        int currentNum = 0;
        //循环变量
        int i = 0;
        for (; i < minLength; i++) {
            //分别获取两个字符对应的字面数值，然后相加，再加上进位
            currentNum = str1.charAt(i) + str2.charAt(i) - 2 * '0' + carry;
            //获取进位
            carry = currentNum / 10;
            //处理当前位的最终值
            currentNum %= 10;
            //保存当前位的值到最终的字符缓冲区中
            result.append(String.valueOf(currentNum));
        }
        if (str1.length() < str2.length()) {
            //选择
            str1 = str2;
        }
        for (; i < str1.length(); i++) {
            //分别获取两个字符对应的字面数值，然后相加，再加上进位
            currentNum = str1.charAt(i) - '0' + carry;
            //获取进位
            carry = currentNum / 10;
            //处理当前位的最终值
            currentNum %= 10;
            //保存当前位的值到最终的字符缓冲区中
            result.append(String.valueOf(currentNum));
        }
        //处理最后一个的进位(当循环结束后，是不是还可能会有一个进位)
        if (carry > 0) {
            result.append(String.valueOf(carry));
        }
        //最后翻转恢复字符串，再返回
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("123333444455555555555", "99999999999999999999999"));
    }

}
