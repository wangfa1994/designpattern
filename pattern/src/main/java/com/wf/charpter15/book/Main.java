package com.wf.charpter15.book;

import com.wf.charpter09.bjsxt.Pad;
import com.wf.charpter15.book.pagemaker.PageMaker;

/**
 * @Author: wangfa
 * @Date: 2020/2/25 11:38
 * @Description: Facade模式
 * 外观模式---->简单窗口
 *
 * 程序越来越大，类越来越多，关系越来越复杂，导致程序结构也越来越复杂。
 *
 *
 * facade模式可以为相互关联在一起的错综复杂的类整理出高层接口(API),其中Facade角色可以让对外的系统只有一个简单地接口(API)
 * 而且，Facade角色还会考虑到系统内部个各类之间的责任关系和依赖关系，按照正确的顺序进行调用各个接口。
 */
public class Main {


    /**
     * facade模式需要许多相互关联切错综复杂的类，为了演示，简化为三个类构成的系统
     * 用于从邮件地址中获取用户名字的数据库类，一个用于编写HTML文件的类，一个扮演Facade角色并提供高层接口的类
    **/
    public static void main(String[] args) {

        PageMaker.makeWelcomePage("wang@163.com","welcome.html");

    }
}
