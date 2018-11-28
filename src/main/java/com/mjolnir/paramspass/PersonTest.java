package com.mjolnir.paramspass;

/**
 * @author huangzhibo
 * @date 2018/10/30
 */
public class PersonTest {

    public static void personCrossTest(Person person) {
        System.out.println("传入的person的name：" + person.getName());
        person.setName("张先森");
        System.out.println("方法内重做赋值后的name：" + person.getName());
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("马先生");
        person.setAge(55);
        personCrossTest(person);
        System.out.println("方法执行后的name：" + person.getName());
    }

}
