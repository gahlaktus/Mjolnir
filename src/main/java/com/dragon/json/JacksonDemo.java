package com.dragon.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 25/09/2017
 */
public class JacksonDemo {

    public static void main(String[] args) throws ParseException, JsonProcessingException, IOException{
        User user = new User();
        user.setName("小明");
        user.setEmail("xxxaaaa@163.com");
        user.setAge(22);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateFormat.parse("1993-11-11"));

        /*
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        List<User> users = new ArrayList<>();
        users.add(user);
        String jsonList = mapper.writeValueAsString(users);
        System.out.println(jsonList);

        System.out.println("###############################################");
        /*
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        String json1 = "{\"name\":\"小明\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
        User user1 = mapper.readValue(json1, User.class);
        System.out.println(user1);

        System.out.println("###############################################");

        JsonNode rootNode = mapper.readTree(json1);
        String name = rootNode.path("name").textValue();
        int age = rootNode.path("age").intValue();
        System.out.println(name);
        System.out.println(age);

        System.out.println(JacksonDemo.class.getName());

        System.out.println("###############################################");

        ContractMsgItem msgItem = new ContractMsgItem();
        msgItem.setAge(12);
        msgItem.setName("xxxxuuuu");
        System.out.println(msgItem.stringValue());

    }

}
