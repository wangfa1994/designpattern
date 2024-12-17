package com.wf.charpter04.bjsxt.abstractfactory;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:05
 * @Description:
 */
public class HighCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new HighEngine();
    }

    @Override
    public Seat createSeat() {
        return new HighSeat();
    }

    @Override
    public Tyre createTyre() {
        return new HighTyre();
    }
}
