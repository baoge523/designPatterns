package com.baoge.designpattern.create.singleton;

import java.io.Serializable;

/**
 * 通过枚举模式来实现单例模式 (最完美的)
 *
 * 在java规范里面说明了，java中的枚举类没有构造器。
 * 即便是通过反射也不能创建枚举类的对象
 *
 *
 *  ---------------------------------
 *  需要怎么序列化和反序列化会不会使用枚举类也产生多个对象
 *
 *  ---结果: 反序列化出来的对象还是原来的那个对象
 *
 */
public enum SingletonEnum implements Serializable {
    INSTANCE
}
