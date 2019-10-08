package com.wf.charpter01.bjsxt;

import javax.sound.midi.Soundbank;

/**
 * @Author: wangfa
 * @Date: 2019/9/29 16:18
 * @Description:
 */
public class Client {

    /**
     * 迭代器模式
     * 遍历聚合对象的一种方式
     * 聚合对象:存储数据
     * 迭代器:遍历数据
     *
     * 迭代器接口一般未做内部类接口:可以直接操作聚合对象的属性，而且一般某一迭代器只针对某一类的对象进行迭代
     */


    public static void main(String[] args) {

        ConcreteMyAggregate concreteMyAggregate = new ConcreteMyAggregate();

        concreteMyAggregate.addObject("a");
        concreteMyAggregate.addObject("b");
        concreteMyAggregate.addObject("c");

        MyIterator iterator = concreteMyAggregate.getIterator();

        while (iterator.hasNext()){
            Object currentObject = iterator.getCurrentObject();
            System.out.println(currentObject);
            iterator.next();
        }


    }
}
