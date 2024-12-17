package com.wf.charpter21.proxy;

import com.wf.charpter21.proxy.dynamicproxy.ProxyUtilDyn;
import com.wf.charpter21.proxy.dynamicproxy.TeacherDaoDynamicProxyInvocationHandler;
import com.wf.charpter21.proxy.jdk.TeacherDaoInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Author: wangfa
 * @Date: 2020/3/25 22:44
 * @Description:
 */
public class Main {


    public static void main(String[] args) {


        // 模拟 对TeacherDaoImpl 增强代理，逻辑写死的方式
        TeacherDao teacherDao = (TeacherDao)ProxyUtil.newInstance(new TeacherDaoImpl());
        teacherDao.selectStudent();
        teacherDao.getAge(12,25);


        System.out.println("jdk ===================");



        /**
         * 模拟动态代理的动态逻辑的方式
         *
         */

        System.out.println("customer模拟 ===================");
        TeacherDao teacherDaoDym = (TeacherDao) ProxyUtilDyn.newInstancedDynamic(TeacherDao.class, new TeacherDaoDynamicProxyInvocationHandler(new TeacherDaoImpl()));
        teacherDaoDym.selectStudent();
        teacherDaoDym.getAge(12, 25);
    }
}
