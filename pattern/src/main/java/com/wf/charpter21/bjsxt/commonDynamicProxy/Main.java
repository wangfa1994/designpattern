package com.wf.charpter21.bjsxt.commonDynamicProxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        XiaoLiTeacher xiaoLiTeacher = new XiaoLiTeacher();
        CommonHandler commonHandler = new CommonHandler(xiaoLiTeacher);
        Class[] interfaces = {TeacherInterface.class};
        TeacherInterface proxyInstance = (TeacherInterface)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces, commonHandler);
        proxyInstance.teach("okk");

        System.out.println("===========================================");

        XiaoWangStudent xiaoWangStudent = new XiaoWangStudent();
        CommonHandler commonHandler1 = new CommonHandler(xiaoWangStudent);
        Class[] interfaces1 = {StudentInterface.class};
        StudentInterface proxyInstance1 = (StudentInterface)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces1, commonHandler1);
        System.out.println("最后获得的结果:"+proxyInstance1.study("ok"));


    }
}
