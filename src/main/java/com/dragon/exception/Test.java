package main.java.com.exception;

/**
 * Created by huangzhibo on 07/06/2017.
 */
public class Test {

    public static void main(String[] args) {

        Exception e = new IndexOutOfBoundsException();
        System.out.println(ExceptionUtil.getStackTrace(e));

        e.printStackTrace();
    }
}
