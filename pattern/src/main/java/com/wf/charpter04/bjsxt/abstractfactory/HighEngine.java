package com.wf.charpter04.bjsxt.abstractfactory;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:00
 * @Description:
 */
public class HighEngine implements  Engine{
    @Override
    public void run() {
        System.out.println("高价发动机run");
    }

    @Override
    public void start() {
        System.out.println("高价发动机start");

    }
}
