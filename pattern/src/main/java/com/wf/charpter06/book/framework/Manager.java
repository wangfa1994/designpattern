package com.wf.charpter06.book.framework;

import java.util.HashMap;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 10:01
 * @Description:  调用createClone方法复制实例的类
 *
 * 使用了Product 接口来复制实例
 */
public class Manager {


    /**
     * 用来保存实例的名字和实例之间的对应关系
     */
    private HashMap showcase = new HashMap();


    /**
     * Product 类型的参数proto 具体是什么，我们无法知道，但是他肯定是实现了Product接口的类的实例(可以调用他的use方法和createClone方法)
     *
     */
    public   void register(String name,Product proto){
        showcase.put(name,proto);

    }


    public Product create(String protoname){
        Product product = (Product) showcase.get(protoname);
        return product.createClone();

    }






















    /**
     * 在Product接口 和Manager类的代码中完全没有出现MessageBox类和UnderlinePen类的名字，这也意味着我们可以独立的修改
     * Product 和Manager，不受MessageBox类和UnderlinePen类的影响。在Manager类中，并没有写明具体的类名，仅仅使用了Product
     * 这个接口名，也就是说，Product接口成为了连接Manager类与其他具体类之间的桥梁
     *
     * 一旦在类中使用了别的类名，就意味着该类域其他类紧密地耦合在了一起
     *
     */

}
