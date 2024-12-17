package com.wf.charpter21.bjsxt.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wangfa
 * @Date: 2019/5/12 17:08
 * @Description:
 */
public class StartHandler implements InvocationHandler {

    // 这个只是针对star进行增强
    private Star realStar;

    public StartHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("真正的方法执行前。。面谈。合同");

        if(method.getName().equals("sing")){
            //method.invoke(realStar,args);
              Object obj = method.invoke(realStar,args);
            System.out.println(obj);
        }

        System.out.println("真正的方法执行后。。收款");

        return null;
    }
}
