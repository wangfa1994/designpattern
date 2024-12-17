package com.wf.charpter05.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 10:44
 * @Description: 饿汉式模式  天然线程安全 效率高 不支持延迟加载
 *
 */
public class HungrySingleton {

    private static HungrySingleton  instance = new HungrySingleton();


    private HungrySingleton(){
    }

    public static HungrySingleton getInstance(){
        return instance;
    }

}
