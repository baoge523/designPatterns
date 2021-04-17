package com.baoge.designpattern.create.singleton;

/**
 * 懒汉式
 *
 *  双重校验锁  + volatile
 *
 */
public class Idler05 {

    /**
     * volatile 具有 可见性  MESI --CPU缓存一致性来解决的
     *               禁止指令重排  禁止JVM的内部优化
     *     禁止指令重排:
     *      new Object(); 看似只有一条语句，其实内部对应着多个指令
     *          -- 1、分配内存的指令
     *          -- 2、初始化成员变量默认值的指令
     *          -- 3、初始化成员变量指定值的指令
     *          -- 4、引用赋值的指令
     *      在超高并发的情况下，可能拿到未执行完这些指令的对象，如只执行了1和2，此时对象已经不是null引用了
     *
     */
    private static volatile Idler05 idler05;

    private Idler05 () {}

    public static Idler05 getInstance() {
        if (idler05 == null) {
            synchronized (Idler05.class) {
                if (idler05 == null) {
                    idler05 = new Idler05();
                }
            }
        }
        return idler05;
    }

}
