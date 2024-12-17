package com.wf.charpter07.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 15:12
 * @Description: 装配者调用构建者
 */
public class BjsxtAirShipDirector implements AirShipDirector {


    private AirShipBuilder builder;

    public BjsxtAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {

        // 构建
        Engine engine = builder.builderEngine();
        OrbitalModel orbitalModel = builder.builderOrbitalModel();
        EscapeTower escapeTower = builder.builderEscapeTower();

        //装配
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModel(orbitalModel);

        return airShip;
    }
}
