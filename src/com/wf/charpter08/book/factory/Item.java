package com.wf.charpter08.book.factory;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:50
 * @Description: 方便统一处理Link 和Tray 的类
 *
 * Item是Link和Tray类的父类(Item有项目的意思),这样Link和Tray类就具有可替换性了
 */
public abstract class Item {

    // 表示项目的标题
    protected String caption;

    public  abstract String makeHTML();

    public Item(String caption) {
        this.caption = caption;
    }
}
