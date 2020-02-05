package com.wf.charpter10;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: 分开考虑-----> Strategy模式(整体的替换算法)
 */
public class DemoMain {
    /**
     * Strategy 模式中的角色
     *
     * Strategy(策略)
     * strategy角色负责决定实现策略所必须的接口(API)。
     * 示例中的strategy接口
     *
     * ConcreteStrategy(具体的策略类)
     * ConcreteStrategy角色负责实现Strategy角色的接口(API),即负责实现据图的策略(方法，算法，方向，战略)。
     *  示例中的WinningStrategy 和 ProbStrategy
     *
     *  Context(上下文)
     *  负责使用Strategy角色，Context角色保存了ConcreteStrategy角色的实例，并使用ConcreteStrategy角色去实现需求(调用Strategy角色的接口)
     *  示例中的Player
     *
     *
     *
     *
     * 扩展:
     *  1)为什么要特意编写strategy角色，strategy模式将算法与其他部分进行分离开来，只是定义了与算法相关的接口，
     *  然后在程序中以委托的方式使用算法，这样的好处是，我们使用了strategy模式，就不必修改strategy角色的接口(API),仅仅修改
     *  ConcreteStrategy角色即可。而且，使用了委托这种弱关联关系可以很方便的整体替换算法。
     *  2)程序中可以切换策略，在程序运行时可以切换ConcreteStrategy角色，象棋程序中切换AI水平
     *
     */
}
