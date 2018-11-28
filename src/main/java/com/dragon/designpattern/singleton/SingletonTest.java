package com.dragon.designpattern.singleton;

import java.lang.reflect.Constructor;

/**
 *
 * 借助AccessibleObject.setAccessible()方法，通过反射机制，调用私有构造器创建新的实例。
 *
 * @author huangzhibo
 * @date 10/10/2017
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception{

        HungerTaskManager s1 = HungerTaskManager.getInstance();
        HungerTaskManager s11 = HungerTaskManager.getInstance();
        System.out.println(s1 == s11);

        Class<HungerTaskManager> cls = HungerTaskManager.class;
        Constructor<HungerTaskManager> constructor = cls.getDeclaredConstructor(new Class[]{});
        constructor.setAccessible(true);

        HungerTaskManager s2 = constructor.newInstance(new Object[]{});
        System.out.println(s1 == s2);


        // 静态内部类

        IODHTaskManager h1 = IODHTaskManager.getInstance();
        IODHTaskManager h11 = IODHTaskManager.getInstance();

        System.out.println(h1 == h11);

        Class<IODHTaskManager> cls1 = IODHTaskManager.class;
        Constructor<IODHTaskManager> constructor1 = cls1.getDeclaredConstructor(new Class[]{});
        constructor1.setAccessible(true);
        IODHTaskManager h2 = constructor1.newInstance(new Object[]{});
        System.out.println(h1 == h2);


        // 单元素枚举类型实现Singleton

        EnumTaskManager e1 = EnumTaskManager.INSTANCE;
        e1.doSomething();
        EnumTaskManager e2 = EnumTaskManager.INSTANCE;
        e2.doSomething();
        System.out.println(e1 == e2);


        // 使用反射机制时会抛异常
        Class<EnumTaskManager> cls2 = EnumTaskManager.class;
        Constructor<EnumTaskManager> constructor2 = cls2.getDeclaredConstructor(new Class[]{});
        constructor2.setAccessible(true);
        EnumTaskManager e3 = constructor2.newInstance(new Object[]{});
        System.out.println(e1 == e3);
    }


}
