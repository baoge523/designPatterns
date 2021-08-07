package com.baoge.designpattern.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Calculate target = new MyCalculate();
        Calculate calc = (Calculate) Proxy.newProxyInstance(MyCalculate.class.getClassLoader(), MyCalculate.class.getInterfaces(), (proxy, method, params) -> {
            System.out.println("代理方法执行了");
            return method.invoke(target, params);
        });
        calc.add(1,1);


    }
}
