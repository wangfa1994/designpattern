package com.wf.charpter04.bjsxt.simplefactory;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:24
 * @Description: 简单工厂模式 （静态工厂模式） 对于增加新的产品无能为力，不修改代码 的话，无法进行扩展
 *
 * 创建者和调用者分离
 */
public class CarFactory {

    public static Car factoryCreateCar(String type){
        if("Audi".equals(type)){
            return new Audi();
        }else if ("Benz".equals(type)){
            return new Benz();
        }
        return null;
    }
}
