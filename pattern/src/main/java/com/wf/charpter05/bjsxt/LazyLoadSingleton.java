package com.wf.charpter05.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 10:51
 * @Description: 懒加载模式 线程安全 效率不高 支持延迟加载
 */
public class LazyLoadSingleton {

    private  static LazyLoadSingleton instance;

    private  LazyLoadSingleton(){
    }

    // 注意 synchronized
    public static synchronized LazyLoadSingleton getInstance(){
        if(null == instance){
            instance = new LazyLoadSingleton();
        }
        return instance;
    }
}
