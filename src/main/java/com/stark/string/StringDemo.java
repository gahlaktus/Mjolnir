package com.stark.string;

/**
 * @author huangzhibo
 * @date 2019/6/5
 */
public class StringDemo {


    public static void test0(){
        String s1 = "aaa";
        String s2 = "aaa";
        System.out.println(s1 == s2);
    }

    public static void test1(){
        String s3 = new String("aaa");
        String s4 = new String("aaa");
        System.out.println(s3 == s4);
    }

    public static void test2(){
        String s0 = "helloworld";
        String s1 = "helloworld";
        // 一个字符串常量由多个字符串常量连接而成，它本身也是字符串常量。
        String s2 = "hello" + "world";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
    }

    public static void test3(){
        String s0 = "helloworld";
        String s1 = new String("helloworld");
        String s2 = "hello" + new String("world");
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s1 == s2);
    }

    public static void test4(){
        String s0 = "ab";
        String s1 = "b";
        String s2 = "a" + s1;
        System.out.println(s0 == s2);
    }

    public static void test5(){
        String s1 = "abc";
        String s2 = "def";
        String s3 = s1 + s2;
        System.out.println(s3 == "abcdef");
    }

    public static void test6(){
        String s0 = "javalanguagespecification";
        String s1 = "java";
        String s2 = "language";
        String s3 = "specification";
        System.out.println(s0 == "java" + "language" + "specification");
        System.out.println(s0 == s1 + s2 + s3 );
    }

    public static void test7(){
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1;
        System.out.println(s0 == s2);
    }

    public static void test8(){
        String s0 = "ab";
        final String s1 = getS1();
        String s2 = "a" + s1;
        String s3 = "a" + getS1();
        System.out.println(s0 == s2);
        System.out.println(s0 == s3);
    }

    private static String getS1(){
        return "b";
    }

    public static void testIntern(){
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = new String("kvill");
        System.out.println("===========testIntern============");
        System.out.println( s0 == s1 );
        System.out.println( "**********" );
        s1.intern();
        s2 = s2.intern();
        System.out.println( s0 == s1); //flase
        System.out.println( s0 == s1.intern() ); //true//说明s1.intern()返回的是常量池中"kvill"的引用
        System.out.println( s0 == s2 ); //tru
    }

    public static void main(String[] args) {
//        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        testIntern();




    }

}
