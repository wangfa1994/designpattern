package com.wf.charpter17;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {

    /**
     * Observer模式角色
     *
     * Subject(观察对象)
     * Subject角色表示观察对象，Subject角色定义了注册和删除观察者的方法，此外，他还声明了"获取现在状态"的方法(NumberGenerator抽象类扮演)
     *
     * ConcreteSubject(具体的观察对象)
     * ConcreteSubject角色表示具体的被观察对象。当自身状态发生变化后，他会通知所有已经注册的Observer(RandomNumberGenerator类扮演)
     *
     * Observer(观察者)
     *Observer角色负责接收来自Subject角色的状态变化的通知，为此，他声明了update方法(Observer接口扮演)
     *
     * ConcreteObserver(具体的观察者)
     * ConcreteObserver角色表示具体的Observer。当他的update方法被调用后，会去获取要观察的最新状态(DigitObserver和GraphObserver类扮演)
     *
     *
     *扩展:
     * 1、出现了可替换性
     * 使用设计模式的目的之一就是是类成为可复用的组件
     * 在Observer模式中，有带状态的ConcreteSubject和接收状态变化通知的ConcreteObserver角色。而连接这两个角色的就是他们的接口Subject和Observer
     * 一方面说RandomNumberGenerator并不知道也不需要知道正在观察自己的对象(自己需要通知的对象)是DigitObserver还是GraphObserver实例。
     * 只需要知道在Observers字段中保存的观察者们都实现了Observer接口，也就一定可以调用update方法。
     * 另一方面，Observer也无需在意自己正在观察的是RandomNumberGenerator类的实例还是其他XXXNumberGenerator类的实例。
     * 只需要知道他们是RandomNumberGenerator类的子类。并持有getNumber方法。
     *
     * 利用抽象类和接口从具体类中抽出抽象方法。
     *再将实例作为参数传递到类中，或者在类的字段中保存实例时，不使用具体类型，而是使用抽象类型和接口
     *这样的实现方式可以帮助我们轻松的替换具体类
     *
     * 2、Observer的顺序
     * Subject角色中注册的多个Observers，通常需要注意调用顺序，在示例程序中，先注册的先被调用update方法。
     * 在设计ConcreteObserver时，需要注意调用的顺序，不能因为调用顺序的改变而发生问题。
     * 在示例程序中，绝对不能因为先调用DigitObserver的方法后调用GraphObserver的update方法而产生问题
     * 通常，我们保持个各类的独立性，就不会产生上述类的关系依赖混乱的问题。
     *
     * 注意:当Observer的行为对Subject产生影响时
     * 在示例程序中，RandomNumberGenerator会在类的内部产生数值，调用update方法，但是，在通常的Observer模式中，也可能是
     * 其他类触发Subject角色调用update方法，当然，Observer角色也有可能触发Subject角色调用update方法，如果稍不留神就会产生
     * 循环调用:Subject状态改变---->通知Observer---->Observer调用Subject的方法---->导致Subject状态改变---->通知Observer.....
     *
     * 3、传递更新信息的方式(update方法的定义方式)
     * NumberGenerator利用update方法告诉Observer自己的状态发生了改变。传递给update的参数只有一个，
     * 就是调用update方法的NumberGenerator自身的实例，Observer会在update方法中调用该实例的getNumber方法来获取足够的数据。
     * 在示例程序中，update方法接收到的参数中并没有被更新的数值，也就是说，update方法的定义可能
     *  a----void update(NumberGenerator generator);
     *  b----void update(NumberGenerator generator,int number);
     *  c----void update(int number);
     *  a中传递了Subject角色，Observer可以从Subject角色中获取数据
     *  b中传递了Subject角色，并且还传递了Observer所需要的其他数据(代指所有的更新信息)，这样就省去了Observer自己获取数据的麻烦，
     *  但是这样的话，Subject角色就知道了Observer角色所要处理的内容了。(在很复杂的程序中，让Subject角色知道Observer角色的处理逻辑，
     *  会让程序变得缺少灵活性)
     *  c比b简单，省略了Subject角色，不过如果一个Observer角色需要观察多个Subject时，此方法就不适用了，
     *  这是因为Observer角色不知道传递给update方法的参数究竟属于那个Subject的数值
     *
     *  4、从"观察"变成"通知"
     *  Observer角色并不是主动去观察，而是被动的接收来自Subject的通知，因此，Observer模式，也被成为Publish-Subscribe(发布-订阅)模式
     *
     * 5、MVC
     *    Model与View的关系就是Subject与Observer的关系，一个Model对应多个View
     *
     *
     * 延伸:
     * 1、java.util.Observer接口和 java.util.Observable类就是一种Observer模式
     * 但是不好用，java是单继承，java.util.Observer接口的Subject角色必须是java.util.Observable类型或者子类，
     * 而如果Subject已经是某个类的子类了，则没有办法继承Observable类了
     *
     */


}
