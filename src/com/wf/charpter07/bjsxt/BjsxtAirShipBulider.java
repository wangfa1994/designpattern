package com.wf.charpter07.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 15:08
 * @Description:
 */
public class BjsxtAirShipBulider implements AirShipBuilder {

    @Override
    public OrbitalModel builderOrbitalModel() {
        System.out.println("构建Bjsxt 轨道舱");

        // 和工厂模式结合处
        return new OrbitalModel("sxt");
    }

    @Override
    public Engine builderEngine() {
        System.out.println("构建Bjsxt 发动机");
        return new Engine("sxt");
    }


    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建Bjsxt 逃逸塔");

        return new EscapeTower("sxt");
    }
}
