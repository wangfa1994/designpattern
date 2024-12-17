package com.wf.charpter01;

/**
 * @Author: wangfa
 * @Date: 2019/9/23 09:41
 * @Description:
 */
public class Domain {


    /**
     *
     * @Author: wangfa
     * @Date: 2019/9/29 下午5:41
     * @Description:
     *
     *
     *
     * 迭代器模式角色
     *
     * Iterator(迭代器)
     * 该角色负责定义按顺序逐个遍历元素额的接口(API)
     *
     *
     * ConcreteIterator(具体的迭代器)
     * 该角色负责实现Iterator角色的接口，该角色中包含了遍历集合所必需的信息
     *
     * Aggregate(集合)
     * 该角色负责定义创建Iterator角色的接口，(标记这个接口具有迭代器功能，需要获取对应的Iterator迭代器)
     * 这个接口是一个方法，会创建出"按照"顺序访问保存在我内部元素的人
     *
     * ConcreteAggregate(具体的集合)
     * 该角色负责实现Aggregate角色所定义的接口，
     * 他会创建出具体的Iterator角色，及ConcreteIterator角色。
     */



}
