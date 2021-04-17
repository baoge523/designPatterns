package com.baoge.designpattern.create.singleton;

/**
 * 懒汉式
 *
 *  缩小synchronized的代码范围
 *
 */
public class Idler03 {

    private static Idler03 idler03;

    private Idler03 (){}

    /**
     * 这样改写后，虽然synchronized锁住的代码块变小了，其他的线程等待的时间变短了。
     * 但是这样还是存在线程安全问题:
     *      当多个线程同时访问getInstance方法时，多个线程会同时进入判断，然后抢锁
     *      抢到锁就会创建一个新的对象，同样也会创建出多个对象
     *
     * @return
     */
    public static Idler03 getInstance(){
        if (idler03 == null) {
            // 一个线程拿到锁，其他线程等待
            synchronized (Idler03.class) {
                idler03 = new Idler03();
            }
        }

        return idler03;
    }



}
