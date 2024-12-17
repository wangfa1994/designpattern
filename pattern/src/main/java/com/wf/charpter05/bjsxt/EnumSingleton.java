package com.wf.charpter05.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 11:11
 * @Description: 枚举本身就是单例模式，从jvm层次方面提供了保障，避免通过反射和反序列化的漏洞
 * 不支持延迟加载 线程安全 效率高
 *
 */
public enum EnumSingleton {

    /**
     * 定义一个枚举元素， 代表一个Singleton的一个实例
     */
    INSTANCE;

    /**
     * 可以有自己的操作
     */

    public void singletonOperation(){
        //功能处理

    }

}
