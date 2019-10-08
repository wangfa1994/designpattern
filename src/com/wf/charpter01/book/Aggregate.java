package com.wf.charpter01.book;

/**
 * @Author: wangfa
 * @Date: 2018/12/22 09:43
 * @Description: 表示所要遍历的集合的接口
 * 实现该接口的类将成为一个可以保存多个元素的集合
 */
public interface Aggregate {
    /**
     * 生成一个用于遍历集合的迭代器，想要遍历集合时，可以调用该方法生成一个实现类
     * Iterator接口的实现类的实例
     *
     *
     */
     Iterator iterator();


}
