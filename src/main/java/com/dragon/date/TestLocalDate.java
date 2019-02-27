package com.dragon.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author huangzhibo
 * @date 2019/2/15
 */
public class TestLocalDate {

    public static void main(String[] args) {

        try {

            SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

            SimpleDateFormat sdfMins = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date now = new Date();

            String today = sdfDay.format(now);

            String wStart = today + " 03:00:00";
            String wEnd = today + " 04:00:00";

            Date wStartTime = sdfMins.parse(wStart);
            Date wEndTime = sdfMins.parse(wEnd);

            System.out.println(wStartTime);
            System.out.println(wEndTime);

            LocalDateTime now1 = LocalDateTime.now();
            LocalDateTime waterStart = LocalDateTime.of(now1.getYear(), now1.getMonth(), now1.getDayOfMonth(), 3, 0);
            LocalDateTime waterEnd = LocalDateTime.of(now1.getYear(), now1.getMonth(), now1.getDayOfMonth(), 4, 0);

            System.out.println(waterStart);
            System.out.println(waterEnd);

        } catch (ParseException e){
            e.printStackTrace();
        }

    }

}
