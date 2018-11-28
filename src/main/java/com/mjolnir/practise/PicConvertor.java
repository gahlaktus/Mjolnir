package com.mjolnir.practise;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author huangzhibo
 * @date 06/02/2018
 */
public class PicConvertor {

    /**
     * 将图片使用md5加密
     * @param file
     * @param salt
     * @return
     * @throws Exception
     */
    private static byte[] img2Md5Bytes(File file, String salt) throws Exception {

        FileInputStream inputStream = new FileInputStream(file);
        StringBuilder builder = new StringBuilder();
        byte[] bytes = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(bytes)) != -1){
            builder.append(new String(bytes, 0, bytesRead));
        }
        inputStream.close();
        builder.append(salt);
        String md5 = md5(builder.toString());
        return hexStringToBytes(md5);
    }

    /**
     * 16进制转字节数组
     * @param hexString
     * @return
     */
    private static byte[] hexStringToBytes(String hexString){
        if (hexString == null || hexString.equals("")){
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 6 | charToByte(hexChars[pos+1]));
        }
        return d;
    }

    private static byte charToByte(char c){
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * md5加密字符串
     */
    private static String md5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        }catch (Exception e){
            return "";
        }
    }

}
