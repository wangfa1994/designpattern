package com.wf.charpter09.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/29 19:16
 * @Description: Bridge模式------>将类的功能层次结构与实现层次结构分离
 *
 * Bridge模式的作用是将两个东西连接起来，他们分别是类的功能层次结构和类的实现层次结构
 * 是在类的功能层次结构和类的实现层次结构之间进行搭建桥梁
 *
 *
 * 类的层次结构的两个作用(类的功能层次结构和类的实现层次结构)
 *  ----希望增加新功能时，子类进行继承父类(类层次结构)，为了增加新功能而产生的层次结构。父类具有基本功能，在子类中新增实现新的功能，这叫做类的功能层次结构。
 *  ----希望增加新的实现时，父类的任务是通过声明抽象方法的方式定义接口(API)，而对于子类的任务就是实现抽象方法，类层次结构并非用于新增功能，而是用来帮助我们实现不同的任务分担，
 *      父类通过声明抽象方法来定义接口(API)，子类通过实现具体方法来实现接口，这叫做类的实现层次结构。
 *
 *
 * 当我们想要编写子类时，需要明白自己的意图是要新增功能还是增加实现，当类的层次结构只有一层时，功能层次结构与实现层次结构是混杂在一个层次结构中的。这样很容易使类的层次结构变得复杂，
 * 也很难彻底理解类的层次结构，因为自己难以确定究竟应该在类的哪一个层次结构中去增加子类。
 *
 * 我们需要将类的功能层次结构与类的实现层次结构分离为两个独立的类层次结构，如果只是简单的将他们分开，两者之间必然会缺少联系，所有我们需要搭建一个桥梁用于连接他们的层次关系。
 */
public class Main {


    public static void main(String[] args) {

        /*
        ** 显示一些东西
        *  Display 类的功能层次结构，负责显示的类
        *  CountDisplay 类的功能层次结构，增加了"只显示规定次数"这一功能的类
        *  DisplayImpl 类的实现层次结构，负责显示的类
        *  StringDisplayImpl 类的实现层次结构 用字符串显示的类
        *
         */

        Display d1 = new Display(new StringDisplayImpl("hello,universe"));
        Display d2 = new CountDisplay(new StringDisplayImpl("hello,universe"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("hello,universe")); //增加功能用的是子类实例
        d1.display();
        System.out.println("000000000000000000000000");
        d2.display();
        System.out.println("000000000000000000000000");
        d3.display(); //自己的实现层次
        d3.multiDisplay(5); // 增加的功能层次


        /**
         * 有一种将类的实现层次结构，组合到类的功能层次结构里面。进行桥接。
         */
    }
}
