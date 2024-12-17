package com.wf.charpter21.proxy.dynamicproxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: wangfa
 * @Date: 2020/3/26 12:43
 * @Description: 将目标对象放置到代理逻辑的对象中
 */
public class TeacherDaoDynamicProxyInvocationHandler implements DynamicProxyInvocationHandler {

    // 目标对象
    private Object target;

    public TeacherDaoDynamicProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object[] args) {
        try {
            System.out.println("代理逻辑处理...");
            return method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
