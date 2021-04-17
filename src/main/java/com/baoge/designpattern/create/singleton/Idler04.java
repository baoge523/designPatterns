package com.baoge.designpattern.create.singleton;

/**
 * 懒汉式
 *
 *  双重检查锁 -- double-check
 *
 */
public class Idler04 {

    private static Idler04 idler04;

    private Idler04 () {}

    // 这已经很完美了，一般场景的高并都不会有问题，可能在超高并发的情况下存在问题 -- 指令重排序问题
    private static Idler04 getInstance() {

        // 这里也有更高级的写法 -- 用一个局部变量保存 idler04的值
        // double-check
        if (idler04 == null) {
            synchronized (Idler04.class) {
                if (idler04 == null) {
                    idler04 = new Idler04();
                }
            }
        }
        return idler04;
    }


}
