package com.dawanglu;

import com.solarterms.kokuu.commons.util.base.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author huangzhibo
 * @date 2019/3/14
 */
public class CalendarDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date endDate = calendar.getTime();
        System.out.println(DateUtils.format(endDate, DateUtils.FMT_SECOND));
        calendar.add(Calendar.MONTH, -6);
        Date beginDate = calendar.getTime();
        System.out.println(DateUtils.format(beginDate, DateUtils.FMT_SECOND));
    }

}
