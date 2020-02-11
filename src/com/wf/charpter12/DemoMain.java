package com.wf.charpter12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.Reader;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {


    /** 装饰者模式
     * Decorator模式角色
     *
     * Component
     * 增加功能时的核心角色，(装饰前的蛋糕就是Component角色，Component角色只定义了蛋糕的接口，Display类扮演角色)
     *
     * ConcreteComponent
     * 该角色是实现了Component角色所定义的接口的具体蛋糕，StringDisplay类扮演角色
     *
     * Decorator(装饰物)
     * 该角色具有与Component角色相同的接口，在它内部保存了被装饰对象Component角色，Decorator角色要知道自己装饰的对象的。Border类扮演
     *
     * ConcreteDecorator(具体的装饰物)
     * 该角色是具体的Decorator角色，有SideBorder和FullBorder角色扮演
     *
     *
     *
     *
     *
     * 扩展:
     * 1)接口的透明性
     * 在装饰者模式中，装饰边框与被装饰物具有一致性。`
     * (在程序中，表示边框的Border类是表示被装饰物的Display类的子类，体现了他们的一致性,也就是说Border类及子类，与表示被装饰物的Display类具有相同的接口)
     * 这样做，即使被装饰物被边框装饰起来了，接口API也不会被隐藏起来，其他类依旧可以调用getColumns相关方法，
     * 得益于接口API的透明化，Decorator模式也形成了类似Composite模式中的递归结构，装饰边框里面的被装饰物实际上又是别的物体的装饰边框。
     * 就像剥洋葱，以为是葱心，但是还是皮。
     * Decorator模式虽然与Composite模式类似，都具有递归结构，但是他们使用的目的不一样，
     * Decorator模式的主要目的是通过添加装饰物来增加对象的功能。
     *
     * 2)在不改变被装饰物的前提下增加功能
     * 在Decorator模式中，装饰边框与被装饰物具有相同的接口，虽然接口是相同的，但是越装饰，功能越多。
     * 用sideBorder装饰Display后，可以再用FullDisplay装饰，我们完全不需要对被装饰者的类做任何修改，实现了，不修改被装饰的类即可增加功能。
     * Decorator模式，使用了委托，对装饰边框提出的要求(调用装饰边框的方法)会被委托给"被装饰物去处理，(SideBorder类的getColumns调用display的方法)
     *
     * 3)可以动态的增加功能
     * Decorator使用了委托弱关联关系，可以在不改框架代码就可以生成一个与其他对象具有不同关系的新对象。
     *
     * 4)只需要一些装饰物即可添加许多功能
     *  使用Decorator模式可以为程序添加许多功能，只要准备一些装饰边框(ConcreteDecorator角色)，
     *  即使装饰边框只具备非常简单的功能，也可以将他们组合成新的对象(香草冰淇淋，巧克力冰淇淋，草莓冰淇淋，香草草莓冰淇淋)
     *
     * Decorator模式就是可以应对这种多功能对象的需求的一种模式
     *
     * 5)java.io 与Decorator模式
     *
     * 6) 导致增加许多很小的类
     * 增加许多功能类似的很小的类
     *
     */


    public static void main(String[] args)  throws Exception{

        Reader reader  = new FileReader("datafile.txt");

        Reader reader1 = new BufferedReader(new FileReader("datafile.txt"));

        Reader reader2 = new LineNumberReader(
                                new BufferedReader(
                                        new FileReader("datafile.txt")
                                ));
    }
}
