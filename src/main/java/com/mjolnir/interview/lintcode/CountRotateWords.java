package com.mjolnir.interview.lintcode;

import java.util.HashSet;
import java.util.List;

/**
 * @author huangzhibo
 * @date 01/03/2018
 */
public class CountRotateWords {

    public int countRotateWords(List<String> words) {
        if (words == null || words.size() == 0){
            return 0;
        }
        HashSet<String> wordSet = new HashSet<>();
        for (String word : words){
            boolean exist = false;
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(i, word.length())+word.substring(0,i);
                if (wordSet.contains(newWord)){
                    exist = true;
                    break;
                }
            }
            if (!exist){
                wordSet.add(word);
            }
        }
        return wordSet.size();
    }

}
