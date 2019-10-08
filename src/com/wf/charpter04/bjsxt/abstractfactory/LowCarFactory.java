package com.wf.charpter04.bjsxt.abstractfactory;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:05
 * @Description:
 */
public class LowCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
