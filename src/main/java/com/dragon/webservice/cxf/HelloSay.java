package com.dragon.webservice.cxf;

import javax.jws.WebService;

/**
 * Created by huangzhibo on 06/04/2017.
 */
@WebService
public interface HelloSay {
    public String sayHello(String msg);
}
