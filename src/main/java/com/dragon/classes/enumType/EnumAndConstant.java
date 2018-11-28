package com.dragon.classes.enumType;

/**
 * Created by huangzhibo on 22/04/2017.
 */
public class EnumAndConstant {

    /* TODO: extends learn -> 内部类&静态类; */

    /**
     * 比较枚举与常量
     */

    // 在 Java 程序中通过常量定义方式来实现彩虹的七种颜色
    public static class Rainbowcolor {

        // 红橙黄绿青蓝紫七种颜色的常量定义
        public static final int RED = 0;
        public static final int ORANGE = 1;
        public static final int YELLOW = 2;
        public static final int GREEN = 3;
        public static final int CYAN = 4;
        public static final int BLUE = 5;
        public static final int PURPLE = 6;

        /**
         * 存在问题：
         * 1. 类型不安全；如在程序执行过程中很有可能给颜色变量传入一个任意的整数值，导致错误。
         * 2. 没有命名控件；颜色常量只是类的属性，需要通过类来访问。
         * 3. 一致性差；因为整形枚举属于编译期常量，所以编译过程完成后，所有客户端和服务器端引用的地方，会直接将整数值写入。
         *    这样，当你修改旧的枚举整数值后或者增加新的枚举值后，所有引用地方代码都需要重新编译，否则运行时刻就会出现错误。
         * 4. 类型无指意性；由于颜色枚举值仅仅是一些无任何含义的整数值，如果在运行期调试时候，你就会发现日志中有很多魔术数字，但除了程序员本身，其他人很难明白其奥秘。
         */
    }

    // enum 类型的值实际上是通过运行期构造出对象来表示的，所以在 cluster 环境下，每个虚拟机都会构造出一个同义的枚举对象。
    // 因而在做比较操作时候就需要注意，如果直接通过使用等号 ( ‘ == ’ ) 操作符，这些看似一样的枚举值一定不相等，因为这不是同一个对象实例。

}

