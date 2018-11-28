package com.dragon.log.demo0;

import java.lang.reflect.Method;

/**
 * Created by huangzhibo on 24/04/2017.
 */
public class MyLoggerImpl implements MyLogger{

    @Override
    public void saveIntoMethodTime(Method method) {
        System.out.println("进入"+method.getName()+"方法时间为："+System.currentTimeMillis());
    }

    @Override
    public void saveOutMethodTime(Method method) {
        System.out.println("退出" + method.getName() + "方法时间为：" + System.currentTimeMillis());

    }
}
