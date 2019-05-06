package com.stark.concurrency;

/**
 * @author huangzhibo
 * @date 2019/5/5
 */
public class Message {


    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String str) {
        this.msg=str;
    }

}
