package com.dragon.webservice.cxf;

import javax.jws.WebService;

/**
 * Created by huangzhibo on 06/04/2017.
 */
@WebService
public class HelloSayImpl implements HelloSay{

    public String sayHello(String msg) {
        System.out.println("CXF的webservice被调用");
        return "Hello "+msg;
    }
}
