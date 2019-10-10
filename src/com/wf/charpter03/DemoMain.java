package com.wf.charpter03;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: 模板方法模式(将具体处理交给子类)
 *
 * 父类中定义处理流程的框架，在子类中实现具体处理的模式
 */
public class DemoMain {

    /**
     *
     * template method 模式中角色
     *
     *
     * AbstractClass(抽象类)
     * abstractClass不仅负责实现模板方法，还负责声明在模板方法中用到的抽象方法，这些抽象方法有子类ConcreteClass角色负责实现
     *
     *
     * ConcreteClass(具体类)
     * ConcreteClass具体实现AbstractClass角色中定义的抽象方法，这里实现的方法将在AbstractClass角色中的模板方法中被调用
     *
     *
     *
     */
}
