package com.mjolnir.design.callback;

import javax.xml.bind.DatatypeConverter;

/**
 * @author huangzhibo
 * @date 2018/6/4
 */
public class InstanceCallbackDigestUserInterface {

    private String fileName;
    private byte[] digest;

    public InstanceCallbackDigestUserInterface(String fileName){
        this.fileName = fileName;
    }

    public void calculateDigest(){
        InstanceCallbackDigest cb = new InstanceCallbackDigest(fileName, this);
        Thread t = new Thread(cb);
        t.start();
    }

    void receiveDigest(byte[] digest){
        this.digest = digest;
        System.out.println(this);
    }

    @Override
    public String toString() {
        String result = fileName + ": ";
        if (digest != null){
            result += DatatypeConverter.printHexBinary(digest);
        }else {
            result += "digest not available";
        }
        return result;
    }

    public static void main(String[] args) {
        for (String fileName : args){
            InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(fileName);
            d.calculateDigest();
        }
    }
}
