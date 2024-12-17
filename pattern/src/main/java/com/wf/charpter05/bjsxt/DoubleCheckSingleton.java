package com.wf.charpter05.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 10:54
 * @Description: 双重检测锁模式
 * 由于存在编译器优化原因和JVM底层内部模型原因，偶尔会出现问题，不建议使用
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    // 将关键字syn写到内部，这样不需要每次调用都使用同步代码块
    public static DoubleCheckSingleton getInstance() {
        if (null == instance) {
            DoubleCheckSingleton instanceNew;
            synchronized (DoubleCheckSingleton.class) {
                instanceNew = instance;
                if (null == instanceNew) {
                    synchronized (DoubleCheckSingleton.class) {
                        if (null == instanceNew) {
                            instanceNew = new DoubleCheckSingleton();
                        }
                    }
                    instance = instanceNew;
                }
            }
        }
        return instance;
    }
}
