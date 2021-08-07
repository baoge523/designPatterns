package com.baoge.designpattern.proxy;

public class MyCalculate implements Calculate {
    @Override
    public int add(int i, int j) {
        System.out.println(i+j);
        return i+j;
    }
}
