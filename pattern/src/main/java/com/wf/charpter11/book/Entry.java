package com.wf.charpter11.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/5 18:00
 * @Description: 抽象类，为了将File和Directory统一起来，我们设计了父类Entry
 * 用来实现File类和Directory类的一致性
 *
 *
 */
public  abstract class Entry {


    /**
     * 目录条目有一个名字，我们通过getName进行获取，由子类进行实现
     *
     */
    public abstract String  getName();

    /**
     * 目录条目还有大小，通过getSize进行获取，由子类进行实现
     */
    public abstract int getSize();

    /**
     * 用于显示文件夹中的内容一览， protected修饰
     */
    protected   abstract void printList(String prefix);


    public void printList(){
        printList("");
    }



    public Entry add(Entry entry) throws FileTreatementException{
        throw new FileTreatementException();
    }

    @Override
    public String toString() {
        return getName()+ "("+getSize()+")";
    }
}
