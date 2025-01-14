package com.wf.charpter21.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
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

        addClassToDisk(proxy.getClass().getName(), proxy.getClass());

        System.out.println("TeacherDaoInvocationHandler 我们的代理逻辑处理");

        // 目标对象的处理
        return method.invoke(target,args);
    }


    private void addClassToDisk(String className, Class<?> cl) {
        //用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;
        try {
            // jdk 动态代理会在项目的根目录下生成对应的class文件，$Proxy
            out = new FileOutputStream("$Proxy000.class");
            //将代理对象的class字节码写到硬盘上
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
