package com.wf.charpter02.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/12 15:41
 * @Description: 适配器
 * (实现了客户的要求，用于适配双方)
 *
 * (继承方式和组合方式，建议使用组合)
 */
public class Adapter implements  Target {


    private Adaptee adaptee = new Adaptee();


    @Override
    public void handleReq() {
        adaptee.request();

    }
}
