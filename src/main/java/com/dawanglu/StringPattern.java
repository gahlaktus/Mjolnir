package com.dawanglu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangzhibo
 * @date 2019/3/1
 */
public class StringPattern {

    public static void main(String[] args) {
        System.out.println(matchStr("aa aa aa","aaa"));
    }

    public static boolean matchStr(String dataStr, String pattenStr){

        String[] vals = dataStr.split(" ");
        for (String val : vals) {
            System.out.println(val);
        }
        List<String> dataDict = Arrays.stream(vals).distinct().collect(Collectors.toList());
        dataDict.forEach(s -> System.out.println(s + "------"));
        char[] patternSplit = pattenStr.toCharArray();
        String[] pStr = new String[patternSplit.length];
        for (int i = 0; i < patternSplit.length; i++) {
            pStr[i] = String.valueOf(patternSplit[i]);
        }

        List<String> patternDict = Arrays.stream(pStr).distinct().collect(Collectors.toList());
        if (patternDict.size() != dataDict.size()){
            return false;
        }
        for (int i = 0; i < patternDict.size(); i++) {
            dataStr = dataStr.replace(dataDict.get(i), patternDict.get(i));
        }
        if (!pattenStr.equals(dataStr.replace(" ",""))){
            return false;
        }
        return true;

    }

}
