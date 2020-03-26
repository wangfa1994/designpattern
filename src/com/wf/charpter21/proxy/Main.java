package com.wf.charpter21.proxy;

import com.wf.charpter21.proxy.dynamicproxy.ProxyUtilDyn;
import com.wf.charpter21.proxy.dynamicproxy.TeacherDaoDynamicProxyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Author: wangfa
 * @Date: 2020/3/25 22:44
 * @Description:
 */
public class Main {


    public static void main(String[] args) {


        // 模拟 对TeacherDaoImpl 增强代理，逻辑写死的方式
    /*    TeacherDao teacherDao = (TeacherDao)ProxyUtil.newInstance(new TeacherDaoImpl());
        teacherDao.selectStudent();
        System.out.println(teacherDao.getAge(12,25));*/


        // jdk 动态代理
        /**
         *  把你要代理的接口给我，我代理你所有的接口，代理对象是invocation的目标对象，然后增强invocation逻辑
         *
         *  有一种回调的意味，回调我们指定接口实现的类的实现。InvocationHandler
         */
        TeacherDao teacherDao = (TeacherDao) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{TeacherDao.class}, new TeacherDaoInvocationHandler(new TeacherDaoImpl()));
        teacherDao.getAge(12,15);


        /**
         * 模拟动态代理的动态逻辑的方式
         *
         */

       /* TeacherDao teacherDao = (TeacherDao) ProxyUtilDyn.newInstancedDynamic(TeacherDao.class, new TeacherDaoDynamicProxyInvocationHandler(new TeacherDaoImpl()));
        teacherDao.selectStudent();
        teacherDao.getAge(12, 25);*/
    }
}
