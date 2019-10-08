package com.wf.charpter07.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 15:00
 * @Description: 飞船 有三个组件组成
 */
public class AirShip {

    /**
     * 轨道舱
     */
    private OrbitalModel orbitalModel;

    /**
     * 发动机
     */
    private Engine engine;

    /**
     * 逃逸塔
     */
    private EscapeTower escapeTower;


    /**
     *  可以定义我们相要的操作
     */

    public void engineStart(){
        System.out.println(this.getEngine().getName()+"启动");
    }



    public OrbitalModel getOrbitalModel() {
        return orbitalModel;
    }

    public void setOrbitalModel(OrbitalModel orbitalModel) {
        this.orbitalModel = orbitalModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}
