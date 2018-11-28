package com.mjolnir.design.callback;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author huangzhibo
 * @date 2018/6/4
 */
public class InstanceCallbackDigest implements Runnable {


    private String fileName;
    private InstanceCallbackDigestUserInterface callback;

    public InstanceCallbackDigest(String fileName, InstanceCallbackDigestUserInterface callback){

        this.fileName = fileName;
        this.callback = callback;

    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            // 读取整个文件
            while (din.read() != -1) {}
            din.close();
            byte[] digest = sha.digest();
            callback.receiveDigest(digest);
        }catch (IOException | NoSuchAlgorithmException ex){
            System.err.println(ex);
        }
    }
}
