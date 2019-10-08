package com.wf.charpter03.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/8 19:02
 * @Description:
 */
public abstract class AbstractDisplay {

    /**
     * 交给子类去实现的方法
     */
    public abstract void open();

    public abstract void print();

    public abstract void close();


    /**
     * 本抽象类实现的display方法 ，注意是final
     */
    public final void display(){
        open();
        for (int i = 0; i <5; i++) {
            print();
        }
        close();

    }
}
