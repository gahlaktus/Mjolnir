package main.java.com.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author huangzhibo
 * @date 07/06/2017
 */
public class ExceptionUtil {

    public static String getStackTrace(final Exception e){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(outputStream));
        return outputStream.toString();
    }
}
