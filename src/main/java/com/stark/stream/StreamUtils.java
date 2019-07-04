package com.stark.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangzhibo
 * @date 2019/6/25
 */
public class StreamUtils {


    public static void main(String[] args) {

        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

        //Create stream of dates
        List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());

        //System.out.println(dates);

        LocalDate maxDate = dates.stream().max(Comparator.comparing(LocalDate::toEpochDay))
                .get();



    }


}
