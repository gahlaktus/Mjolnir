package main.java.com.enums;

/**
 * Created by huangzhibo on 27/05/2017.
 */
public class Main {
    public static void main(String[] args) {

        AppContext.INSTANCE.init();

        System.out.println(SystemConstants.DATA_A);
        System.out.println(SystemConstants.DATA_B);
    }
}
