package com.wf.charpter04.bjsxt.abstractfactory;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:04
 * @Description:
 */
public interface CarFactory {

    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
