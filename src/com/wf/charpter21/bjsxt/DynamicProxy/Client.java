package com.wf.charpter21.bjsxt.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Author: wangfa
 * @Date: 2019/5/12 17:09
 * @Description:
 */
public class Client {


    public static void main(String[] args) {
        Star realStar = new RealStar();
        StartHandler startHandler = new StartHandler(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, startHandler);
            proxy.sing();
            proxy.confer();
    }
}
