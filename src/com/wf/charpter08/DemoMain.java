package com.wf.charpter08;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {


    /**
     * Abstract Factory 模式中的登场角色
     *
     * AbstractProduct(抽象产品)
     * AbstractProduct角色负责定义AbstractFactory角色所生成的抽象零件和产品的接口(API).(Link类，Tray类，Page类扮演)
     *
     * AbstractFactory(抽象工厂)
     * AbstractFactory角色负责定义用于生成抽象产品的接口(API).(Factory类扮演)
     *
     * Client(委托者)
     * Client角色仅会调用AbstractFactory角色和AbstractProduct角色的接口来进行工作，对于具体的零件，产品和工厂一无所知。
     *
     *
     * ConcreteProduct(具体的产品)
     * ConcreteProduct角色负责实现AbstractProduct角色的接口.(listfactory包和tablefactory包)
     *
     * ConcreteFactory(具体的工厂)
     * ConcreteFactory角色负责实现AbstractFactory角色的接口(listfactory包和tablefactory包ListFactory,TableFactory)
     *
     *
     *
     * 扩展
     * 1)易于增加具体的工厂
     * 2）难以增加新的零件
     */
}
