package com.wf.charpter07.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/3 16:40
 * @Description: 定义了决定结构的方法的抽象类(决定了结构的方法的抽象类，定义不同的方法，表示建造不同的物体)
 * <p>
 * Builder类是声明了一个编写文档的方法的抽象类
 */
public abstract class Builder {

    /**
     * 编写标题
     */
    public abstract void makeTitle(String title);

    /**
     * 编写字符串
     */
    public abstract void makeString(String string);

    /**
     * 编写条目
     */
    public abstract void makeItems(String[] items);

    /**
     * 完成文档编写
     */
    public abstract void close();

}
