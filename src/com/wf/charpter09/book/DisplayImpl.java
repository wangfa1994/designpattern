package com.wf.charpter09.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/29 19:46
 * @Description: 类的实现层次结构，负责显示的类
 * 位于类的实现层次结构的最上层
 *
 * displayImpl 是抽象类
 */
public abstract class DisplayImpl {
    public abstract void rawOpen();

    public abstract void rawPrint();

    public abstract void rawClose();
}
