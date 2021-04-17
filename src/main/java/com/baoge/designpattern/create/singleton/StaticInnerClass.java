package com.baoge.designpattern.create.singleton;

/**
 * 静态内部类的方式
 *
 * 静态内部类同样也是利用了JVM类加载的特性，保证了线程安全性
 *
 *  分析:
 *    首先: 在加载StaticInnerClass类的时候,不会加载InnerClass,于是就不会初始化StaticInnerClass对象
 *
 *    然后: 在调用getInstance方法时，此时才会加载InnerClass类，才会初始化StaticInnerClass对象
 *
 *
 *
 */
public class StaticInnerClass {


    private StaticInnerClass(){}

    private static class InnerClass{
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return InnerClass.instance;
    }

    public static void main(String[] args) {
        StaticInnerClass instance = getInstance();
        System.out.println(instance);
        System.out.println(getInstance());
    }



}
