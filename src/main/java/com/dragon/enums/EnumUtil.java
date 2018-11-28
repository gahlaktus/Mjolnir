package main.java.com.enums;

import java.util.EnumSet;

/**
 * @author huangzhibo
 * @date 07/06/2017
 */
public class EnumUtil {

    public static <T extends Enum<T>> String getEnumString(Class<T> clazz, String str){
        for (T en : EnumSet.allOf(clazz)){
            if (en.name().equalsIgnoreCase(str)){
                return en.name();
            }
        }
        return null;
    }

    public static <T extends Enum<T>> boolean contains(Class<T> clazz, String s) {

        for (T en : EnumSet.allOf(clazz)) {
            if (en.name().equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}
