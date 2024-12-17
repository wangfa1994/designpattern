package com.wf.charpter07;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: 生成实例---->Builder模式(组装复杂的实例)
 *
 *
 */
public class DemoMain {

    /**
     *Builder模式角色
     *
     * Builder(建造者)
     * Builder角色负责定义用于生成实例接口(API),Builder角色中准备了用于生成实例的方法。
     * 示例中的Builder类扮演此角色。
     *
     * ConcreteBuilder(具体的建造者)
     * ConcreteBuilder角色是负责实现Builder角色的接口的类(API)。这里定义了在生成实例时实际被调用的方法，
     * 此外，在ConcreteBuilder角色中还定义了获取最终生成结果的方法。
     * 示例中的TextBuilder和HTMLBuilder类扮演此角色
     *
     * Director(监工/导向器)
     * Director角色负责使用Builder角色的接口(API)来生成实例，他并不依赖于ConcreteBuilder角色,
     * 为了确保不论ConcreteBuilder角色是如何被定义的，Director角色都能正常工作，它只调用在Builder角色中被定义的方法。
     * 示例中的Director类扮演此角色。
     *
     *
     * Client(使用者)
     * 该角色使用了Builder模式，(Builder模式并不包含Client角色)。
     * 示例中的Main类扮演此角色
     *
     *
     *
     *
     *
     * 扩展:
     * 1)"谁知道什么"，非常重要，就是说，我们需要再编程时注意那个类可以使用那个方法以及使用这个方法好不好。
     * Director类知道调用Builder类的方法来进行编写文档，但是他并不知道它真正使用的是哪个类，也就是说他并不知道
     * 使用的是HTMLBuilder类还是TextBuilder类，还是Builder的其他子类，不过也没有必要知道，因为Director类只是
     * 调用Builder的方法，而子类都已经实现了这些方法。
     * Director类不知道自己使用的是Builder类的哪个子类也好，因为不知道子类才能替换。，不论将哪个子类实例传递进去都可以工作。
     *
     *
     * 2)设计时能决定的事情和不能决定的事情
     * 在Builder类中，需要声明编辑文档(实现功能)所必须的所有方法，Director类中使用的方法都是Builder类提供的，而且Builder类
     * 还必须能够对应将来子类可能添加的需求。
     */


}
