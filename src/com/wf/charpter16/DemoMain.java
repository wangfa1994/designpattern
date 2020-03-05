package com.wf.charpter16;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {

    /**
     * Mediator模式 角色
     *
     * mediator(仲裁者,中介者)
     * Mediator角色负责定义与Colleague角色进行通信和做出决定的接口(API)(Mediator类扮演)
     *
     * ConcreteMediator(具体的仲裁者,中介者)
     * ConcreteMediator角色负责实现Mediator，负责实际做出决定(LoginFrame类扮演)
     *
     * Colleague(同事)
     *Colleague角色负责定义与Mediator角色进行通信的接口(API)(Colleague类扮演)
     *
     * ConcreteColleague(具体的同事)
     *ConcreteColleague角色负责实现Colleague(ColleagueTextFiled,ColleagueButton,ColleagueCheckBox类扮演)
     *
     *
     *
     * 扩展:
     * 1、当发生分散灾难时
     *  由于所有的逻辑都提取到了对应的Mediator中，(LoginFrame的colleagueChanged)。所以如果出现bug，会很容易调试。
     *  通常情况下，面向对象的编程可以帮我们进行分散处理，进行分而治之。
     *  但是有些情况利用分而治之，把处理分散在各个类中是不明智的，
     *  如果只是将该分散的分散在各个类中，而没有将该集中的集中起来，那些分散的类也将成为灾难
     *
     *  2、通信线路的增加
     *  A和B两个实例，进行相互通信(相互之间调用方法)，通信线路会有两条
     *  A、B、C三个实例进行相互通信，通信线路会有6条
     *  A、B、C、D四个实例进行相互通信，通信线路会有12条
     *  A、B、C、D，E五个实例进行相互通信，通信线路会有20条
     * 如果实例很少就不需要Mediator模式，但是随着需求的变化，实例会越来越多，问题迟早会暴露的
     *
     * 3、那些角色可以复用
     * ConcreteColleague可以复用，但是ConcreteMediator很难复用
     */
}
