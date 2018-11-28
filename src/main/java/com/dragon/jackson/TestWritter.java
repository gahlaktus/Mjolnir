package com.dragon.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;

/**
 * @author huangzhibo
 * @date 24/07/2017
 */
public class TestWritter {


    public static void main(String[] args) throws Exception{
        Person person = new Person();
        person.setName("张三");
        person.setGender(1);
        person.setIdentifyNumber(555555555555L);
        Student1 stu1 = new Student1();
        stu1.setAge(19);
        String date = new DateTime().toDate().toString();
        stu1.setEntranceDateStr(date);


        ObjectMapper mapper = new ObjectMapper();

        String perStr = mapper.writeValueAsString(person);
        stu1.setPerson(perStr);

        System.out.println(mapper.writeValueAsString(stu1));


    }

}
