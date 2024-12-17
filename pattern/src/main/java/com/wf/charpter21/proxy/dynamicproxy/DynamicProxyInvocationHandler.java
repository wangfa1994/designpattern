package com.wf.charpter21.proxy.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @Author: wangfa
 * @Date: 2020/3/26 12:32
 * @Description: 模拟我们自己的invocationHandler,
 */
public interface DynamicProxyInvocationHandler {


    public Object invoke(Method method,Object[] args);
}
