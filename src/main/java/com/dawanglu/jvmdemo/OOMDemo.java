package com.dawanglu.jvmdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huangzhibo
 * @date 2019/4/8
 */
public class OOMDemo {

    public static void main(String[] args) {

        new Thread(() -> {
            List<byte[]> list = new ArrayList<>();
            while (true){
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                byte[] b = new byte[1024*1024*1];
                list.add(b);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
