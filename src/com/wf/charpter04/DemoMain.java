package com.wf.charpter04;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: Factory Method(将实例的生成交给子类)
 *
 */
public class DemoMain {

   /**
    *
    * factory method 中的角色
    *
    *
    * Product(产品)
    * product角色属于框架的一方，是一个抽象类。他定义了在factory method模式中生成的那些实例所持有的API,但是具体的处理则是由子类ConcreteProduct角色决定。
    *
    *
    * Creator(创建者Factory)
    * creator角色属于框架的一方，他是负责生成Product角色的抽象类，但具体的处理则由子类ConcreteCreator角色决定。
    * Creator角色对于实际负责生成实例的ConcreteCreator角色一无所知，唯一知道的就是只要调用Product角色和生成实例的方法，就可以生成Product的实例
    * (不用new 关键字来生成实例，而是调用生成实例的专用方法类生成实例，这样就可以防止父类与其他具体类耦合)
    *
    *
    * ConcreteProduct(具体的产品)
    * ConcreteProduct角色属于具体加工这一方，他决定了具体的产品。
    *
    * ConcreteCreator(具体的创建者)
    * ConcreteCreator角色属于具体加工的这一方，他负责生产具体的产品。
    *
    *
    *
    * 在Iterator模式中使用Iterator方法生成Iterator的实例时，会使用Factory method模式
    */
}
