package com.stark.concurrency;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

/**
 * @author huangzhibo
 * @date 2019/5/7
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//                c.countDown();
//                System.out.println(2);
//                c.countDown();
//            }
//        }).start();
//        c.await();
//        System.out.println(3);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        String str = String.valueOf(calendar.get(Calendar.DATE));

        System.out.println(str);

    }

}
