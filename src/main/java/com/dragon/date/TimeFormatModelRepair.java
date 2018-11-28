package com.dragon.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangzhibo on 06/06/2017.
 */
public class TimeFormatModelRepair {
    private Date date;

    public TimeFormatModelRepair(){
    }

    public TimeFormatModelRepair(Date date){
        this.date = (Date)date.clone();
    }

    public Date getDate() {
        return (Date)date.clone();
    }

    public void setDate(Date date) {
        this.date = (Date)date.clone();
    }

    @Override
    public String toString() {
        return "TimeFormatModel{"+"date="+formatTime()+"}";
    }

    private String formatTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return format.format(date.getTime());
    }
}
