package com.dragon.log.demo0;

import java.lang.reflect.Method;

/**
 * Created by huangzhibo on 24/04/2017.
 */
public interface MyLogger {

    /**
     *
     * 日志类接口
     */
    void saveIntoMethodTime(Method method);

    void saveOutMethodTime(Method method);
}
