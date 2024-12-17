package com.wf.charpter09.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/29 19:45
 * @Description: 类的功能层次结构，负责显示的类
 *
 * Display的功能是抽象的，负责"显示一些东西"，该类位于类的功能层次结构的最上层
 *
 */
public class Display {


    /**
     * 保存实现了display类的具体功能的实例，
     * 该实例通过构造函数被传递给Display类，保存在impl字段中(此字段即是两个层次结构的桥梁)
     */
    private DisplayImpl impl;


    public Display(DisplayImpl impl) {
        this.impl = impl;
    }


    /**
     * 显示前的处理
     */
    public void open(){
        impl.rawOpen();
    }

    /**
     * 显示处理
     */
    public void print(){
        impl.rawPrint();
    }

    /**
     * 显示后的处理
     */
    public void close(){
        impl.rawClose();
    }

    /**
     * 3个方法的实现都调用了impl字段的实现方法，Display的接口API就被转换成DisplayImpl的接口
     * display方法调用open,print,close这3个display类的接口(API)进行了显示处理。
     */


    public final void display(){
        open();
        print();
        close();
    }
}
