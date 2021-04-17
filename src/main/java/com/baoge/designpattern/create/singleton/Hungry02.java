package com.baoge.designpattern.create.singleton;

/**
 * 饿汉式的变种写法
 *
 * 通过静态代码块来实现
 *
 * 也是基于JVM的类加载来实现线程安全
 *
 */
public class Hungry02 {

    private static Hungry02 hungry02;

    static {
        hungry02 = new Hungry02();
    }

    private Hungry02(){}

    public static Hungry02 getInstance() {
        return hungry02;
    }


}
