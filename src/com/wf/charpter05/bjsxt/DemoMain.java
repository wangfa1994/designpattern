package com.wf.charpter05.bjsxt;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 10:49
 * @Description:
 * 占用资源少，不需要延迟加载时，枚举优于饿汉
 * 占用资源大，需要延迟加载时，静态内部类优于懒汉式
 *
 */
public class DemoMain {

    public static void main(String[] args) throws Exception {

        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(instance);


        EnumSingleton singleton = EnumSingleton.INSTANCE;
        fn();
    }

    /**
     * 反射不能破解枚举类其余的都可以破解
     * 通过反射的方式直接调用私有构造器
     * 修改 构造器 判断对象不为空 直接抛出异常
     */

    public static void fn() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<HungrySingleton> clazz = (Class<HungrySingleton>) Class.forName("com.wf.charpter05.bjsxt.HungrySingleton");

        Constructor<HungrySingleton> constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);

        HungrySingleton hungrySingleton = constructor.newInstance();
        HungrySingleton hungrySingleton1 = constructor.newInstance();
        System.out.println(hungrySingleton+"\n"+hungrySingleton1);
    }

    /**
     *
     * 测试性能 多线程环境下
     * 静态内部类 > 枚举式 > 懒汉式
     *
     *
     * CountDownLatch
     * 同步辅助类 ，在完成一组正在其他线程中执行的操作之前，她允许一个或者多个线程一直等待
     * countDown() 当前线程调用此方法，则计数减一，
     * await() 调用此方法会一直阻塞当前线程，知道计数器的值为0
     */

    public  static void fn1() throws InterruptedException {
        long start= System.currentTimeMillis();

        int threadNum =10;
        // 定义final 是因为要在内部类使用
      final  CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i=0;i<100000;i++){
                        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
                    }
                    countDownLatch.countDown();
                }

            }).start();
        }
        countDownLatch.wait();
        long end = System.currentTimeMillis();

        System.out.println("时间差---"+ (end-start));


    }
}
