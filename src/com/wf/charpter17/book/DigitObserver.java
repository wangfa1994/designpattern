package com.wf.charpter17.book;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 17:02
 * @Description: 表示以数字形式显示的数值的类
 */
public class DigitObserver implements Observer {


    /**
     * 接收NumberGenerator的实例作为参数，然后通过调用NumberGenerator类的实例的getNumber方法获取当前的数值，
     * 并将这个数值展示出来，
     */
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("DigitObserver："+numberGenerator.getNumber());

        try {
            // 单纯的为了降低程序运行速度，更便于观察
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
