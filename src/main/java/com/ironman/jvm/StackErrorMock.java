package com.ironman.jvm;

/**
 * @author huangzhibo
 * @date 2018/11/9
 */
public class StackErrorMock {


    private static int index = 1;

    public void call() {
        index ++;
        call();
    }

    public static void main(String[] args) {

        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable t){
            System.out.println("Stack deep : " + index);
            t.printStackTrace();
        }

    }

}
