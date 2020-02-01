package com.wf.charpter02;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {


    /**
     *  Adapter模式中的角色
     *
     *
     *  Target(对象)
     *  该角色负责定义所需要的方法,(即我们的需求，类似Print接口(使用继承)和Print类(使用委托)扮演此角色)
     *
     *  Client(请求者)
     *  该角色负责使用Target角色所定义的方法进行具体的处理，
     *
     *  Adaptee(被适配)
     *  Adaptee是一个持有既定方法的角色，（即我们的现状，类似于Banner类，如果Adaptee的方法与Target方法一致的话，就不需要Adapter了）
     *
     *
     *  Adapter(适配)
     *  Adapter模式的主人公，使用Adaptee角色来满足Target角色的需求。这是Adapter的目的。也是Adapter角色的作用(类似PrintBanner类)
     *
     *
     *
     *
     *
     * 扩展:
     * 什么时候使用Adapter模式
     *
     *  很多时候我们并不是从零编程，经常用到现有的类，特别是当现有的类已经被充分测试过了，我们更愿意将这些类作为组件进行重复使用。
     *  Adapter模式会对现有的类进行适配，生成新的类，通过该模式可以很方便的创建我们需要的方法群。当出现bug时，我们只需要调查Adapter角色的类即可，。
     *  版本升级域兼容性问题，新版本扮演Adaptee角色，旧版本扮演Target,编写Adapter角色，让他使用新版本的类来实现旧版中的类的方法。
     *
     *
     *
     *
     *
     *
     *
     */
}
