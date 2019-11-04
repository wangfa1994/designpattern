package com.wf.charpter07.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/3 16:40
 * @Description: 定义了决定结构的方法的抽象类
 * <p>
 * Builder类是声明了一个编写文档的方法的抽象类
 */
public abstract class Builder {

    public abstract void makeTitle(String title);

    public abstract void makeString(String string);

    public abstract void makeItems(String[] items);

    public abstract void close();

}
