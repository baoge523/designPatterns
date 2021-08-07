package com.test;

public class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge(boolean flag){
        int initAge = 18;
        if (flag) {
            return initAge;
        }
        return 20;
    }


}
