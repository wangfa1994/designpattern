package com.wf.charpter09;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:Bridge模式(将类的功能层次结构与实现层次结构分离)
 */
public class DemoMain {


    /**
     * Bridge模式中的登场角色
     *
     * Abstraction(抽象化)
     * 该角色位于"类的功能层次结构"的最上层，他使用Implementor角色的方法定义了基本的功能(他使用Implementor角色的方法定义了基本的功能)。
     * 该角色中保存了Implementor角色的实例，(Display类)
     *
     * RefinedAbstraction(改善后的抽象化)
     * 在Abstraction 角色的基础上增加了新功能的角色，(CountDisplay类)
     *
     * Implementor(实现者)
     * 该角色位于"类的实现层次结构"的最上层，它定义了用于实现Abstraction角色的接口(API)的方法，(DisplayImpl类)
     *
     * ConcreteImplementor(具体的实现者)
     * 该角色负责实现在Implementor角色中定义的接口(API),(StringDisplayImpl类)
     *
     *
     *
     * 扩展，
     * 1）分开后更容易扩展。将类的功能层次结构与类的实现层次结构分离有利于独立的对他们进行扩展，
     *  当想要增加功能时，只需要在类的功能层次结构一侧增加类实现即可，不必对类的实现层次结构做任何修改，
     *  而且，增加后的功能可以被"所有的实现"使用。
     *
     * 2)继承是强关联，委托是弱关联
     *  在Display类进行工作时，display类并非自己工作，而是将工作交给impl,这就是委托。
     *
     */
}
