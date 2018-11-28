package com.dragon.date;

import java.util.Date;

/**
 * May expose internal representation by incorporating reference to mutable object
 * This code stores a reference to an externally mutable object into the internal representation of the object.
 * If instances are accessed by untrusted code, and unchecked changes to the mutable object would compromise
 * security or other important properties, you will need to do something different. Storing a copy of the
 * object is better approach in many situations.
 *
 * Created by huangzhibo on 06/06/2017.
 */
public class Bug001 {
    public static void main(String[] args) {

        TimeFormatModel timeFormatModel = new TimeFormatModel();
        Date now = new Date();
        timeFormatModel.setDate(now);
        System.out.println(timeFormatModel.toString());
        now.setYear(4000);
        System.out.println(timeFormatModel.toString());


        TimeFormatModelRepair timeFormatModelRepair = new TimeFormatModelRepair();
        Date now2 = new Date();
        timeFormatModelRepair.setDate(now2);
        System.out.println(timeFormatModelRepair.toString());
        now2.setYear(4000);
        System.out.println(timeFormatModelRepair.toString());
    }
}
