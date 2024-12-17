package com.wf.charpter13.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/12 15:36
 * @Description: 表示数据结构的接口，它接受访问者的访问
 *
 * visitor类表示访问者的类，element则是接受访问者访问的接口
 * visitor代表玛利亚，则element借口就相当于住宿的房间(实际上实现了element接口的类的实例才是实际住宿的地方)
 *
 */
public interface Element {
    void accept(Visitor visitor);
}
