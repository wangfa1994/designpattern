package com.wf.charpter06.book;

import com.wf.charpter06.book.framework.Manager;
import com.wf.charpter06.book.framework.Product;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 09:33
 * @Description:  通过复制生成实例
 *
 *
 * 有时候，我们需要在不指定类名的前提下生成实例
 *  1)对象种类繁多，无法将他们整合到一个类中---->需要处理的对象太多，如果将他们分别作为一个类，必须要编写很多个类文件
 *
 * 2)很难根据类生成实例时--->生成的实例过程太过复杂，很难根据类来生成实例---->在想生成一个和之前用户通过操作所创建出的
 *      实例完全一样的实例的时候，我们会事先将用户通过操作所创建出的实例保存起来，然后在需要时通过复制来生成新的实例
 *
 * 3)想解耦框架与生成的实例时---->想要让生成实例的框架不依赖于具体的类。这时不能指定类名来生成实例，而要事先"注册"一个原型实例，然后
 *      通过复制该实例来生成新的实例
 *
 *
 * 不根据类来生成实例，而是根据实例来生成新的实例----prototype模式
 *  在java 中我们可以使用clone 创建出实例的副本，clone方法与Cloneable接口的使用方法
 */

public class Main {


    /**
     *
     * 将字符串放入方框中显示出来或是加上下划线显示出来
     *
     *
     */
    public static void main(String[] args) {
        // 首先生成Manager的实例，接着在Manager实例中注册了UnderlinePen和MessageBox的实例


        Manager manager = new Manager();

        UnderlinePen upen = new UnderlinePen("~");
        MessageBox mbox = new MessageBox("*");
        MessageBox sbox = new MessageBox("/");

        manager.register("strong message",upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 生成
        Product p1 = manager.create("strong message");
        p1.use("hello world");
        Product p2 = manager.create("warning box");
        p2.use("hello world");

        Product p3 = manager.create("slash box");
        p3.use("hello world");




    }



}
