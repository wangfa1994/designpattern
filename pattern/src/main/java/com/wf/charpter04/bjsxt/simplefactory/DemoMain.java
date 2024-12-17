package com.wf.charpter04.bjsxt.simplefactory;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: 工厂模式
 *
 * 实现了 创建者和调用者的分离
 *
 * 简单工厂模式
 * 工厂方法模式
 * 抽象工厂模式
 *
 *
 * 面向对象设计的基本原则
 *
 * 1,oop 开闭原则    对扩展开放，对修改关闭
 * 2,dip 依赖倒置原则 针对接口编程
 * 3,LoD 迪米特法则  避免与太多对象打交道
 */
public class DemoMain {


    public static void main(String[] args) {
        nofactory();
    }

    public static void nofactory(){
        Car car  = new Audi();
        Car car1 = new Benz();
        car.run();
        car1.run();
    }

    public static void simplefactory(){
        Car car = CarFactory.factoryCreateCar("Audi");
        Car car1 = CarFactory.factoryCreateCar("Benz");
        car.run();
        car1.run();
    }

}
