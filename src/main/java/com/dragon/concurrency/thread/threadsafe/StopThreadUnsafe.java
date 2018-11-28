package com.dragon.concurrency.thread.threadsafe;

/**
 * @author huangzhibo
 * @date 19/10/2017
 */
public class StopThreadUnsafe {


    public static class User{
        private int id;
        private String name;

        public User(){
            id=0;
            name="0";
        }

        @Override
        public String toString() {
            return "User [id=" + id +", name=" + name + "]";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static User user = new User();

    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis()/1000);
                    user.setId(v);
                    // do sth. else
                    System.out.println("in ChangeObjectThread --> "+user.toString());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println("< nonConsistency in ReadObjectThread >"+user.toString());
                    }
                    else {
                        System.out.println("< Consistency in ReadObjectThread >"+user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    /**
     *
     */
    public static class ChangeObjectThread1 extends Thread {
        volatile boolean stopme = false;

        public void stopMe() {
            stopme = true;
        }
        @Override
        public void run() {
            while (true) {
                if (stopme){
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis()/1000);
                    user.setId(v);
                    // do sth. else
                    System.out.println("in ChangeObjectThread --> "+user.toString());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        new ReadObjectThread().start();
        while (true) {
            ChangeObjectThread1 t = new ChangeObjectThread1();
            t.start();
            Thread.sleep(150);
            //t.stop();
            t.stopMe();
        }
    }
}
