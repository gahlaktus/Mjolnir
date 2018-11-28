package com.dragon.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangzhibo on 06/06/2017.
 */
public class TimeFormatModel {

    /**
     * Date 不安全，可被修改！
     */

    private Date date;

    public TimeFormatModel(){
    }

    public TimeFormatModel(Date date){
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
