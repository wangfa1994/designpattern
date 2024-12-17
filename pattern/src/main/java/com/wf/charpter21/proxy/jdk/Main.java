package com.wf.charpter21.proxy.jdk;

import com.wf.charpter21.proxy.TeacherDao;
import com.wf.charpter21.proxy.TeacherDaoImpl;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        // jdk 动态代理
        /**
         *  把你要代理的接口给我，我代理你所有的接口，代理对象是invocation的目标对象，然后增强invocation逻辑
         *
         *  有一种回调的意味，回调我们指定接口实现的类的实现。InvocationHandler
         */
        TeacherDao teacherDaoJdk = (TeacherDao) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{TeacherDao.class}, new TeacherDaoInvocationHandler(new TeacherDaoImpl()));
        teacherDaoJdk.getAge(12,15);
    }
}
