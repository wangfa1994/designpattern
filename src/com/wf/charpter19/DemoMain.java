package com.wf.charpter19;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {

    /**
     * state模式的角色
     *
     * state(状态)
     * state表示状态，定义了根据不同的状态进行不同处理的接口(API)，该接口是那些处理内容依赖于状态的方法的集合(state类扮演)
     *
     * ConcreteState(具体的状态)
     * ConcreteState表示各个具体的状态，他实现了State接口(DayState和NightState类扮演)
     *
     * Context(状况，前后关系，上下文)
     * Context角色持有当前状态的ConcreteState角色，此外，他还提供了外部调用者使用State模式的接口(Context和SafeFrame类扮演)
     *
     *
     * 扩展
     * 1.分而治之
     * 大问题拆解成对应的小问题，直到拆解的可以实现为止，
     * 在State模式中，我们用类表示状态，并且每一种具体的状态都定义一个相应的类，这样的话，问题就会被分解了，当状态非常多的时候，
     * 使用state模式的优势就非常明显了。在不使用state模式的时候，我们需要好多的if分支，并且处理对应的逻辑，导致类过大
     *
     * 2.依赖于状态的处理
     *  定义接口，声明抽象方法
     *  定义多个类，实现具体方法
     *
     *  3.应当是谁来管理状态迁移
     *  用类表示状态，将依赖于状态的处理分散在各个ConcreteState类中，是一种非常好的解决办法，
     *  但是在使用state模式的时候，需要注意应当由谁来管理状态的迁移。
     *
     *  4.不会自相矛盾
     *  如果不使用state模式，我们需要定义多个变量值的集合来表示系统的状态，这时需要十分小心，不要让变量的值之间相互矛盾
     *  在state模式中，我们用类表示状态，，这样我们只需要一个系统变量即可，在示例程序中，SafeFrame的state就是这个变量
     *
     *  5.易于增加新的状态
     *
     *  6.实例的多面性
     *
     *  safeFrame类既实现了Context又实现了ActionListener，注意this的使用
     *  在构造方法buttonUse.addActionListener(this);代表实现了ActionListener的实例
     *  在actionPerformed方法汇中state.doUser(this);代表实现了Context接口的实例
     *
     *
     *
     *
     *
     *
    **/
}
