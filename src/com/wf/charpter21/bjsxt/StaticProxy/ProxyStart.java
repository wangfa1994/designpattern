package com.wf.charpter21.bjsxt.StaticProxy;

/**
 * @Author: wangfa
 * @Date: 2019/5/12 16:57
 * @Description:
 */
public class ProxyStart implements Star {

    private RealStar realStar;

    @Override
    public void confer() {
        System.out.println("代理->confer");
    }

    @Override
    public void signContract() {
        System.out.println("代理->signContract");

    }

    @Override
    public void bookTicket() {
        System.out.println("代理->bookTicket");

    }

    /**
     * 代理
     */
    @Override
    public void sing() {
        realStar.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("代理->bookTicket");
    }

    public ProxyStart(RealStar realStar) {
        this.realStar = realStar;
    }
}
