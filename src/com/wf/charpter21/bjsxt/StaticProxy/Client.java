package com.wf.charpter21.bjsxt.StaticProxy;

/**
 * @Author: wangfa
 * @Date: 2019/5/12 16:59
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        RealStar real = new RealStar();
        Star proxy = new ProxyStart(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
