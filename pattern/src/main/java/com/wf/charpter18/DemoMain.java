package com.wf.charpter18;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {


    /*
     * memento模式中的角色
     *
     * originator(生成者)
     * Originator角色会在保存自己的最新状态时生成的Memento角色，当把以前保存的Memento角色传递给Originator角色时，
     * 他会将自己恢复成生成该Memento角色时的状态(Gamer类扮演)
     *
     * Memento(纪念品)
     * Memento角色会将Originator角色的内部信息整合在一起，在memento角色中虽然保存了Originator角色的信息，但是他不会向外部
     * 公开这些信息(Memento类扮演)
     * Memento角色有两种接口(API)类型
     * 宽接口----wide interface
     * memento角色提供的宽接口是指所有用于获取恢复对象状态信息的方法的集合，由于宽接口会暴露所有的memento角色的内部信息，
     * 因此使用宽接口的只有originator角色。
     * 窄接口----narrow interface
     * memento角色为外部的Caretaker角色提供窄接口，通过窄接口获取的memento角色的内部信息非常有限，可以有效的防止内部信息泄露
     * 可以对外提供以上两种接口，可以有效的防止对象的封装性被破坏
     *
     * 窄宽接口所指的是获取的信息多少的接口，并不是修饰符所修饰的范围
     *
     *
     * Caretaker(负责人)
     * 当caretaker角色想要保存当前originator角色的状态时，会通知originator角色，originator角色会在接收到通知后生成memento角色
     * 然后返回给caretaker角色，由于以后可能会用memento角色恢复originator角色，因此caretaker会一直保存此memento实例。(Main类扮演)
     *注意，caretaker只能使用memento角色的窄接口，没有办法访问所有originator信息，他只是将originator角色生成的memento当成黑盒保存。
     *
     *
     *扩展
      * 1、两种接口(API)和可见性
      * 在memento类中的字段和方法的修饰符不同，这表示设计者希望能够进行控制，从而使某些类可以访问这些字段和方法，
      * 2、需要多个memento
      * caretaker角色可以利用list保存多个memento角色，就可以实现保存各个时间点的对象的状态
      * 3、memento的有效期是多久
      * 在内存中保存时没有问题的，但是如果需要保存在文件中，需要注意当版本升级后。可能出现原来保存的memento与当前程序不匹配的结果
      * 4、划分caretaker角色与originator角色的意义
      * caretaker角色的职责负责决定何时拍摄快照，何时撤销以及保存memento角色实例。
      * originator角色的职责是生成memento角色和利用memento角色恢复状态，这就是职责分担，
      * 当我们需要对应下列需求时，就可以完全不用改originator角色。
      * 变更为可以多次撤销，或者变更为不仅可以撤销，还可以将现在的状态保存在文件中。
     */
}
