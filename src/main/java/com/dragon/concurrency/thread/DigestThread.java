package com.dragon.concurrency.thread;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author huangzhibo
 * @date 21/08/2017
 */
public class DigestThread extends Thread {

    private String fileName;

    public DigestThread(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {

        try {

            FileInputStream fin = new FileInputStream(fileName);

            MessageDigest sha = MessageDigest.getInstance("SHA-256");

            DigestInputStream din = new DigestInputStream(fin, sha);

            while (din.read() != -1);

            din.close();

            byte[] digest = sha.digest();

            StringBuilder sb;
            sb = new StringBuilder(fileName);
            sb.append('\t').append('\n').append(": ").append(DatatypeConverter.printHexBinary(digest));
            System.out.println(sb.toString());

        } catch (NoSuchAlgorithmException | IOException fe){
            System.err.println(fe);
        }
        super.run();
    }

    public static void main(String[] args) {

        DigestThread thread = new DigestThread("/Users/huangzhibo/IdeaProjectsGithub/Dragon/src/com/network/testData.txt");

        thread.start();

    }
}
