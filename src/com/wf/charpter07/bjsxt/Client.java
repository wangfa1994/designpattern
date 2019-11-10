package com.wf.charpter07.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:59
 * @Description:
 * 需要创建很多零件，会产生很多组装模式
 * 建造者和工厂模式搭配使用
 */
public class Client {


    /**
     *  分离了对象子组件的单独构造(Builder负责)和装配(Director负责)，从而构造出复杂的对象
     *  适用于某个对象的构建过程非常复杂的情况下使用
     *  由于实现了构建和装配的解耦，不同的构造器，相同的装配，也可以做出不同的对象
     *  相同的构造器，不同的装配顺序也可以做出不同的对象，实现了构建算法，装配算法的解耦，实现了更好的复用。
     *
     *  以builder结尾的类 构造器
     *  StringBuilder.append  建造者模式
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {

        AirShipDirector director = new BjsxtAirShipDirector(new BjsxtAirShipBulider());
        AirShip airShip = director.directAirShip();
        System.out.println(airShip.getEngine().getName());
    }
}
