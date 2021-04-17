package com.baoge.designpattern.create.singleton;

/**
 * 饿汉式
 *
 * 基于JVM的类加载保证了现场安全
 *
 */
public class Hungry01 {

    private static Hungry01 hungry01 = new Hungry01();

    private Hungry01() {}

    public static Hungry01 getInstance() {
        return hungry01;
    }

}
