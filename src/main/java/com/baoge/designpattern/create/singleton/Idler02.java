package com.baoge.designpattern.create.singleton;

/**
 * 懒汉式
 *
 * 加synchronized锁
 */
public class Idler02 {

    private static Idler02 idler02;

    private Idler02(){}

    /**
     *  因为synchronized锁的是整个方法，这意味着锁住代码执行时间长，其他线程等待时间就会长;
     *  性能比较低
     * 
     * @return
     */
    public static synchronized Idler02 getInstance(){
        if (idler02 == null) {
            idler02 = new Idler02();
        }
        return idler02;
    }

}
