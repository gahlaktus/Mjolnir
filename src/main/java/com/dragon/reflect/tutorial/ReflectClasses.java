package main.java.com.reflect.tutorial;

/**
 * @author huangzhibo
 * @date 04/07/2017
 */
public class ReflectClasses {

    public static void main(String[] args) {
         /*
    * retrieve the class information from a single instance
    * */
        String stringer = "abc";
        Class<? extends String> stringGetClass = stringer.getClass();

    /*
    * directly from the class name without instantiation
    * */
        Class<String> stringClass = String.class;

        try{
            Class.forName("java.lang.String");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
