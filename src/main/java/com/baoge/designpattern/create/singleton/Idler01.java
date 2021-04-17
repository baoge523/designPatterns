package com.baoge.designpattern.create.singleton;

/**
 * 懒汉式
 */
public class Idler01 {


    private static Idler01 idler01;

    private Idler01(){}

    /**
     * 该方法存在线程安全问题:
     *
     * 当有多个线程同时第一次调用getInstance方法时
     *   都会进行判断，且idler01都为空，于是就会出现多个Idler01对象
     *
     *   解决方案 --- 加排他锁
     *
     *
     * @return
     */
    public static Idler01 getInstance() {
        if (idler01 == null) {
            idler01 = new Idler01();
        }
        return idler01;
    }


}
