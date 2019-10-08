package com.wf.charpter04.bjsxt.abstractfactory;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:03
 * @Description:
 */
public class LowTyre implements Tyre {
    @Override
    public void TypePrice() {
        System.out.println("低价车胎");
    }
}
