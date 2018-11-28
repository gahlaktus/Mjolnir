package com.mjolnir.interview.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 02/03/2018
 */
public class SplitString {

    public List<List<String>> splitString(String s){

        List<List<String>> results = new ArrayList<>();
        if (s == null){
            return results;
        }
        else if (s.length() == 0){
            results.add(new ArrayList<>());
            return results;
        }

        dfsHelper(results, new ArrayList<>(), 0, s);
        return results;
    }

    private void dfsHelper(List<List<String>> results, List<String> result, int index, String s){
        if (index == s.length()){
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < index + 2 && i < s.length(); i++){
            String subString = s.substring(index, i + 1);
            result.add(subString);
            dfsHelper(results, result, i + 1, s);
            result.remove(result.size() -1);
        }
    }


    public static void main(String[] args) {
        String s = "1234";
        SplitString splitString = new SplitString();
        List<List<String>> sl = splitString.splitString(s);
        sl.forEach(s1 -> {
            s1.forEach(System.out::println);
            System.out.println("--------");
        });
    }

}
