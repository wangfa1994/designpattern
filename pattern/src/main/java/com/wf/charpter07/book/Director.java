package com.wf.charpter07.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/3 16:40
 * @Description: 编写一个文档的类
 *
 * Director类使用Builder类中声明的方法来编写文档
 *
 *
 * Director 类的构造函数的参数是Builder类型的，
 * 但是实际上我们并不会将Builder类的实例作为参数传递给Director类的，因为Builder是抽象类，无法生成实例，
 * 传递的是Builder类的子类，而正是因为这些Builder类的子类，才决定了编写出不同的文档的形式
 *
 *
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }


    // 编写文档方法(建造)
    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上到下午");
        builder.makeItems(new String[]{"早上好","下午好"});
        builder.makeString("晚上");
        builder.makeItems(new String[]{"晚上好","晚安","再见"});
        builder.close();

    }
}
