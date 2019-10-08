package com.wf.charpter04.bjsxt.factorymethod;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: 工厂方法模式  符合开闭原则(简单模式不符合开闭原则)，但是扩展时，新增的类会非常多
 *
 *
 */
public class DemoMain {

    public static void main(String[] args) {
        Car car = new AudiFactory().createCar();
        Car car1 = new BenzFactory().createCar();
        car.run();
        car1.run();
    }


    /**
     * 简单工厂模式 与 工厂方法模式
     *
     * 1、结构复杂度
     * 2、代码复杂度
     * 3、客户端编程难度
     * 4、管理难度
     *
     * 一般理论使用工厂方法模式  实际开发使用简单工厂模式
     *
     */
}
