package com.mjolnir.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author huangzhibo
 * @date 04/01/2018
 */
public class Demo {

    public static void main(String[] args) {
//        List<String> wordList = new ArrayList<>();
//
//        Stream<String> words = wordList.stream();
//
//        Stream<String> longWords = words.filter(w -> w.length() > 2);
//
//        Stream<String> lowercaseWords = words.map(String::toLowerCase);
//
//        Stream<Character> firstChars = words.map(s -> s.charAt(0));
//
//        Stream<Stream<Character>> result = words.map(w -> characterStream(w));
//
//        Stream<Stream<Character>> result1 = words.map(Demo::characterStream);
//
//        Stream<Character> letters = words.flatMap(w -> characterStream(w));
//
//        Stream<Character> letters1 = words.flatMap(Demo::characterStream);
//
//        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
//
//        String testStr = "";
//        Stream<String> words1 = Stream.of(testStr.split(",")).skip(1);
//
//        Stream<String> uniqueWords = Stream.of("merrily","merrily","merrily","gently").distinct();
//
//        /*
//         * Collections.sort  对原有的集合进行排序；
//         * Stream.sorted 返回一个新的已排序的流。
//         */
//        Stream<String> longestFirst = words.sorted(Comparator.comparing(String::length).reversed());
//
//        /*
//         * 找到第一个以字母Q开头的第一个单词
//         */
//        Optional<String> startsWithQ = words.filter(s -> s.startsWith("Q")).findFirst();
//
//        /*
//         * 任何片段中发眩第一个匹配元素
//         */
//        Optional<String> startsWithQ1 = words.parallel().filter(s -> s.startsWith("Q")).findAny();


        Optional<String> t = Optional.empty();
        Optional<String> op = t.map(s -> {
            System.out.println(s+"hhh");
            return s+"11";
        });
        System.out.println(op.orElse("jk"));

        int count = Stream.of(1, 2, 3).reduce(0, (acc, ele) -> acc + ele);
        System.out.println(count);
    }

    public static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()){
            result.add(c);
        }
        return result.stream();
    }

}
