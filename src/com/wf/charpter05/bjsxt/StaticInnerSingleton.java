package com.wf.charpter05.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 11:05
 * @Description: 静态内部类   延迟加载 线程安全 高效
 */
public class StaticInnerSingleton {

    // 静态内部类
    private static class SingletonClassInstance{
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    private StaticInnerSingleton(){}

    public StaticInnerSingleton getInstance(){
        return SingletonClassInstance.instance;
    }
}
