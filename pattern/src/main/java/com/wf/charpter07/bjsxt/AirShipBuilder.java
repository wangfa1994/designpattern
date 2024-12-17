package com.wf.charpter07.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 15:04
 * @Description: 飞船构建器 由于构建组件
 */
public interface AirShipBuilder {


    OrbitalModel builderOrbitalModel();

    Engine builderEngine();

    EscapeTower builderEscapeTower();

}
