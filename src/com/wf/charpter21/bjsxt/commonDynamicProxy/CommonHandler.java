package com.wf.charpter21.bjsxt.commonDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CommonHandler implements InvocationHandler {

    private Object target;

    public CommonHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入我的通用增强方法..日志打印..参数请求:"+ Arrays.toString(args));
        Object result = method.invoke(target, args);
        System.out.println("退出我的通用增强方法..日志打印..返回结果:"+result);
        return result;
    }
}
