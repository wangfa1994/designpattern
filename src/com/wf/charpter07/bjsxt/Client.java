package com.wf.charpter07.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 14:59
 * @Description:
 */
public class Client {

    public static void main(String[] args) {

        AirShipDirector director = new BjsxtAirShipDirector(new BjsxtAirShipBulider());
        AirShip airShip = director.directAirShip();
        System.out.println(airShip.getEngine().getName());
    }
}
