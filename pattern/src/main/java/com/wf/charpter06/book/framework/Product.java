package com.wf.charpter06.book.framework;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 09:49
 * @Description: 声明了抽象方法use 和 createClone 的接口
 *                 是复制功能的接口
 *
 */
public interface Product extends Cloneable {

    /**
     * 用于使用的方法。具体怎么使用，则被交给子类去实现
     */
    void use(String s);

    /**
     *
     * 用于复制实例的方法
     */
    Product createClone();


}
