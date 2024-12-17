package com.wf.charpter06;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description: 原型模式
 *
 * 通过new 产生一个对象需要非常繁杂的数据准备以及访问权限，则可以使用原型模式
 *
 * 以某个对象为原型，复制出新的对象，新的对象具备原型对象的特点
 *
 * 克隆和拷贝
 *
 * 克隆出来的新对象改变不会影响原型对象，克隆出来的属性完全和原型对象相同
 * clonealbe接口和clone方法
 *
 * 序列化和反序列化
 *
 *
 * 对象不复杂时，完全没有必要使用clone模式
 *
 * spring中的bean的创建 单例模式和原型模式(原型模式与工厂模式搭配起来使用)
 *
 * 原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone 方法创建一个对象，然后由工厂方法提供给调用者
 *
 */
public class DemoMain {
    public static void main(String[] args) {


        /**
         * 在prototype模式中有一下角色
         *
         *
         * Prototype(原型)
         *
         * Prototype 角色负责定义用于复制现有实例来生成新实例方法。(Product 接口扮演此角色)
         *
         * ConcretePrototype(具体的原型)
         * ConcretePrototype 角色负责实现复制现有实例并生成新实例的方法。(MessageBox 和 UnderlinePen类扮演此角色)
         *
         * Client(使用者)
         * Client 角色负责使用复制实例的方法生成新的实例。(Manager 类扮演此角色)
         *
         *
         *
         *
         */


    }
}
