package com.wf.charpter21.bjsxt.StaticProxy;

/**
 * @Author: wangfa
 * @Date: 2019/5/12 16:58
 * @Description:
 */
public class RealStar implements Star {

    @Override
    public void confer() {
        System.out.println("真实->confer");
    }

    @Override
    public void signContract() {
        System.out.println("真实->signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("真实->bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("真实->sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("真实->collectMoney");
    }
}
