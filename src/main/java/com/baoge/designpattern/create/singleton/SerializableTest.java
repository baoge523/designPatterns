package com.baoge.designpattern.create.singleton;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 枚举单例 序列化测试
 *
 * 结果: 枚举对象序列化出来还是原来的那个对象
 *
 */
public class SerializableTest {

    public static void main(String[] args) {

        SingletonEnum instance = SingletonEnum.INSTANCE;
        System.out.println(instance);

        String file = "F:\\aa.txt";

        /**
         *  try-with-resource 是JDK7的新特性用来关闭流的
         *
         *  ObjectOutPutStream 对象输出流，即把对象写入到文件中
         *
         *  ObjectOutPutStream 对象输入流，即把对象从文件中读取出来
         *
         *  注意:
         *  1、序列化多个对象的时候，序列化对象的顺序和反序列化对象的顺序要一致
         *
         *  2、ObjectOutputStream 会绑定一个文件，如果该文件不存在，那么就会创建它
         *
         *  3、ObjectInputStream 会绑定一个文件，如果该文件不存在，那么就会报错 FileNotFindException
         *
         *  4、被序列化的对象需要实现 Serializable 接口
         *
         */
       try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(file)));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(file)))
            ) {
           oos.writeObject(instance);
           oos.flush();
           TimeUnit.SECONDS.sleep(1);
           SingletonEnum o = (SingletonEnum) ois.readObject();
           if (instance == o) {
               System.out.println("序列化出来的对象还是原来的对象");
           }
           System.out.println(o);
       } catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println("aaa");

    }

}
