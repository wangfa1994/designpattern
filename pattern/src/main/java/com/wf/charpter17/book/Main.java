package com.wf.charpter17.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 16:53
 * @Description: Observer模式
 * 观察者模式------>发送状态变化的通知
 *
 * 在Observer模式中，当观察对象发生变化时，会通知给观察者
 *
 * Observer模式，适用于根据对象状态进行相应的处理的场景
 */
public class Main {

    /**
     * 观察者将观察一个会生成随机数的对象，并将它生成的数值展示出来，不过，不同的观察者展示的方式不一样
     * DigitObserver则会以数字的形式进行展示。
     * GraphObserver则会以简单图形进行展示
     */


    public static void main(String[] args) {
        /**
         *
         */
        NumberGenerator numberGenerator  = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        numberGenerator.addObserver(observer1);
        numberGenerator.addObserver(observer2);
        numberGenerator.execute();

    }
}
