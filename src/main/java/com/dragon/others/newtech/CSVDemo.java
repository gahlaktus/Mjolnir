package com.dragon.others.newtech;

import java.util.regex.Pattern;

/**
 * Created by huangzhibo on 27/03/2017.
 */
public class CSVDemo {
    public static String fileName;
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile(",");
//        try (BufferedReader in = new BufferedReader(new FileReader(fileName));){
//            List<Player> players = in
//                    .lines()
//                    .skip(1)
//                    .map(line -> {
//                        String[] arr = pattern.split(line);
//                        return new Player(Integer.parseInt(arr[0]),
//                                arr[1],
//                                arr[2],
//                                arr[3],
//                                Integer.parseInt(arr[4]));
//                    })
//                    .collect(Collector.toList());
//        }
    }
}
