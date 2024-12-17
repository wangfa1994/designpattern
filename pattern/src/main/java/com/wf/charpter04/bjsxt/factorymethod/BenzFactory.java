package com.wf.charpter04.bjsxt.factorymethod;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:39
 * @Description:
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
