package main.java.com.enums;

public class RuleConst {

    public static final String NEW_ADD = "1";
    public static final String FALL_BACK = "2";

    public enum Strategy {

        TIME,
        CHANNEL,
        STATUS,
        CITY;
    }

    public enum Channel {

        电销购买,
        电销转介绍,
        指尖,
        咨询模块,
        抢小姨,
        大数据获客,
        客服400,
        宜人贷,
        上海电销,
        武汉电销;
    }

    public enum Status {
        NEW_ADD, FALL_BACK;
    }

}