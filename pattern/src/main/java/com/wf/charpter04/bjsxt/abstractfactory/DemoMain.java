package com.wf.charpter04.bjsxt.abstractfactory;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 13:52
 * @Description: 抽象工厂模式
 *
 * 用来生成不同产品族的全部产品(对于新增的新的产品，无能为力，支持增加产品族)
 *
 * 抽象工厂模式是在多个业务品种，业务分类时，通过抽象工厂模式产生需要的对象
 */
public class DemoMain {



    public static void main(String[] args) {

        CarFactory carFactory = new HighCarFactory();
        Engine engine  = carFactory.createEngine();
        engine.run();
        engine.start();
        Seat seat = carFactory.createSeat();
        seat.seatCate();

        Tyre tyre = carFactory.createTyre();
        tyre.TypePrice();
    }
}
