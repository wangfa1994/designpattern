package com.wf.charpter08.book.factory;

import java.util.ArrayList;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:51
 * @Description: 抽象零件:表示含有Link和Tray的类
 *
 * Tray类表示的是一个含有多个Link类和Tray类的容器(tray有托盘的意思，在托盘上放置一个一个项目)
 *
 * Tray使用add方法将Link 和Tray类 集合在一起，为了表示集合的对象是Link类和Tray类，
 * 我们设置了add方法的参数为Link类和Tray类的父类Item类
 * 虽然Tray也继承了Item类，但是他并没有实现它，所以他也是抽象方法
 */
public abstract class Tray extends Item{

    protected ArrayList<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void  add(Item item){
        tray.add(item);

    }
}
