package main.java.com.guava;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;

import java.io.UnsupportedEncodingException;

/**
 * Created by huangzhibo on 19/05/2017.
 */
public class UrlSafeEncodingExample {

    public static void main(String[] args) throws UnsupportedEncodingException{

        Preconditions.checkNotNull(args);
        Preconditions.checkNotNull(args[0]);

        String decodedString = args[0];

        System.out.println("Decoded String: "+decodedString);

        //String encodedString = BaseEncoding.base64Url().encode(decodedString.getBytes('UTF-8'));

        String encodedString = BaseEncoding.base64Url().encode(decodedString.getBytes("UTF-8"));

        System.out.println("Encoded String: "+encodedString);


    }
}
