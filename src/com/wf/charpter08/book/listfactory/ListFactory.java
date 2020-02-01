package com.wf.charpter08.book.listfactory;

import com.wf.charpter08.book.factory.Factory;
import com.wf.charpter08.book.factory.Link;
import com.wf.charpter08.book.factory.Page;
import com.wf.charpter08.book.factory.Tray;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:48
 * @Description: 包含具体工厂，零件，产品的包
 *
 * 表示具体工厂的类(制作ListLink,ListTray,ListPage)
 *
 * ListFactory实现了Factory类的createLink,createTray,createPage方法
 * (这里只是简单的new出来对应的实例，实际需求可能会需要Prototype模式来进行clone)
 */
public class ListFactory  extends Factory{

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
