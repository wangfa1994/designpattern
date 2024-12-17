package com.wf.charpter13.book.composite;

import com.wf.charpter13.book.Element;

import java.util.Iterator;

/**
 * @Author: wangfa
 * @Date: 2020/2/5 18:00
 * @Description: 抽象类，为了将File和Directory统一起来，我们设计了父类Entry
 * 用来实现File类和Directory类的一致性
 *
 *
 * 为了让Entry类适用于visitor模式，我们让Entry实现了Element接口，但是实现Element的方法是Entry的子类
 *
 *
 */
public  abstract class Entry implements Element{


    /**
     * 目录条目有一个名字，我们通过getName进行获取，由子类进行实现
     *
     */
    public abstract String  getName();

    /**
     * 目录条目还有大小，通过getSize进行获取，由子类进行实现
     */
    public abstract int getSize();



    public Entry add(Entry entry) throws FileTreatementException {
        throw new FileTreatementException();
    }


    public Iterator iterator() throws FileTreatementException {
        throw new FileTreatementException();
    }


    @Override
    public String toString() {
        return getName()+ "("+getSize()+")";
    }
}
