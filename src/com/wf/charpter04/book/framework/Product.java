package com.wf.charpter04.book.framework;

/**
 * @Author: wangfa
 * @Date: 2019/10/9 19:10
 * @Description:  只定义了抽象方法use的抽象类
 *
 * 用来表示产品的类，在该类中仅声明use 抽象方法，use的实现则被交给Product类的子类来实现
 */
public  abstract class Product {

    public abstract void use();
}
