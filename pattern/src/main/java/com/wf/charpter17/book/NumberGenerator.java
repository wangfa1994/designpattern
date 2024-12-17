package com.wf.charpter17.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 17:00
 * @Description: 生成数值的对象的抽象类
 *
 *
 */
public abstract class NumberGenerator {

    //保存所有观察NumberGenerator 的观察者们
    private List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     */
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * 移除观察者
     */
    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    /**
     * 向Observer发送通知
     */
    public void notifyObservers(){
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer observer = (Observer)iterator.next();
            observer.update(this);
        }
    }


    /**
     * 获取数值，抽象方法，需要子类去实现
     */
    public abstract int getNumber();
    /**
     * 生成数值，抽象方法，需要子类去实现
     */
    public abstract void execute();
}
