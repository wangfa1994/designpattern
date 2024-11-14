package com.wf.charpter21.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wangfa
 * @Date: 2020/3/26 11:57
 * @Description:
 */
public class TeacherDaoInvocationHandler implements InvocationHandler {

    private Object target;

    public TeacherDaoInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy  代理对象
     * @param method 代理对象中的目标对象的方法 我们没有目标对象，可以利用构造器传递进来
     * @param args  对应的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("TeacherDaoInvocationHandler 我们的代理逻辑处理");

        // 目标对象的处理
        return method.invoke(target,args);
    }
}
