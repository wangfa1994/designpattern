package com.wf.charpter05.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 09:15
 * @Description: 单例类，只生成一个实例
 */
public class Singleton {

    /**
     * singleton类定义了static字段(类的成员变量)singleton，并将其初始化为Singleton类实例。
     * 初始化行为仅在改类被加载时进行一次
     *
     */
    private static Singleton singleton = new Singleton();


    private Singleton() {
        System.out.println("生成了一个实例。");
    }

    public static Singleton getInstance(){
        return  singleton;
    }

}
