package com.mjolnir.base;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author huangzhibo
 * @date 2018/12/24
 */
public class CalendarTest {

    public static void main(String[] args) {

        GregorianCalendar d = new GregorianCalendar();

        // 获取当前是几号
        int today = d.get(Calendar.DAY_OF_MONTH);
        // 获取当前月份(从零开始，所以比实际小1)
        int month = d.get(Calendar.MONTH);

        // 重新设置为当前月份第一天
        d.set(Calendar.DAY_OF_MONTH, 1);

        // 获取该天是星期几
        int weekday= d.get(Calendar.DAY_OF_WEEK);

        // 获取当前时区每一周第一天是星期几？
        int firstDayOfWeek = d.getFirstDayOfWeek();
        // 记录该月份第一天与周首天缩进值
        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        // 获取周简称数组
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        // 打印周简称
        do{
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }while (weekday != firstDayOfWeek);

        System.out.println();
        for (int i = 1; i <= indent; i++) {
            System.out.print("    ");
        }
        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if (day == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek){
                System.out.println();
            }
        }while (d.get(Calendar.MONTH) == month);

        if (weekday != firstDayOfWeek){
            System.out.println();
        }

    }

}
