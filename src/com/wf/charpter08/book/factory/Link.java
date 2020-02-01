package com.wf.charpter08.book.factory;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:51
 * @Description: 抽象零件:表示HTML的链接的类
 *
 * Link类是抽象的表示HTML的超链接的类
 * 在Link类中好像一个抽象方法都没有，但是并非如此，
 * 由于Link类中没有实现父类(Item)的抽象方法，所以他也是抽象类
 */
public abstract class Link extends Item {

    // 保存超链接所指向的地址
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
