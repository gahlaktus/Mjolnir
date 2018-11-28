package com.mjolnir.design.singleton;

/**
 * @author huangzhibo
 * @date 21/03/2018
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null){
                    /*
                    这并非是一个原子操作: Jvm
                    1. 给 instance 分配内存
                    2. 调用 Singleton 的构造函数来初始化成员变量
                    3. 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
                    但是在 JVM 的即时编译器中存在指令重排序的优化。
                    也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
                    如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
                    这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，
                    然后顺理成章地报错。
                    */
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
