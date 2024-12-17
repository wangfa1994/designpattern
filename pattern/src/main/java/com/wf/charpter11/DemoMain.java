package com.wf.charpter11;

/**
 * @Author: wangfa
 * @Date: 2019/4/21 15:14
 * @Description:
 */
public class DemoMain {

    /**组合模式
     * Composite模式的角色
     *
     * Leaf(树叶)
     * 表示"内容"的角色，在该角色中不能放入其他对象，由File类扮演角色
     *
     * Composite(复合物)
     * 表示容器的角色。可以再其中放入Leaf角色和Composite角色，由Directory类扮演
     *
     * Component
     * 使Leaf角色和Composite角色具有一致性的角色,Composite角色是Leaf和Composite角色的父类，由Entry类扮演角色
     *
     * Client
     * 使用Composite模式的角色，由Main类扮演此角色
     *
     *
     *
     * 扩展:
     * 1)多个和单个的一致性
     * 使用Composite模式可以使容器与内容具有一致性，也可以成为多个和单个的一致性，即将多个对象结合在一起，当做一个对象进行处理。
     *
     * 2)add方法的位置
     * Entry类中定义了add方法，所做的处理是抛出异常，这是因为能使用add方法的只能是Directory类
     *  a:定义在Entry类中，报错，能使用此方法的只有Directory类，他会重写add方法进行需求处理，File类会继承，但是会报错
     *  b:定义在Entry类中，什么都不做
     *  c:声明在Entry类中，但是抽象的，子类需要add方法就去实现，不需要的话就简单的报错，完全需要子类处理，子类可能需要实现完全不需要的方法
     *  d:只定义在Directory类中，因为只有其使用，所以可以不定义在Entry类中，这样的话，保存的话需要强转为Directory类型
     *
     *
     * 到处都存在的递归结构
     * 通常来说，树结构的数据结构都适用Composite模式
     *
     *
     */
}
