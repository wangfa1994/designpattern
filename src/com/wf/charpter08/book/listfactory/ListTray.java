package com.wf.charpter08.book.listfactory;

import com.wf.charpter08.book.factory.Item;
import com.wf.charpter08.book.factory.Tray;

import java.util.Iterator;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:54
 * @Description:具体零件:表示含有Link 和 Tray 的类
 *
 * ListTray 是Tray的子类，
 *
 * Tray字段保存了所有需要以HTML格式输出的Item,而负责将他们以HTML格式输出的就是makeHTML方法。
 *
 * makeHTML方式是如何实现的？
 * makeHTML方法首先使用<li>标签进行输出标题(caption),接着使用<ul>和<li>标签输出每一个Item，
 * 输出的结果先保存在StringBuffer中，最后通过toString方法将输出的结果转换成String类型并返回。
 *
 * 每个Item又是如何输出为HTML格式的？
 * 调用每个Item的makeHTML方法，注意，这里并不关心变量tem中保存的实例时ListLink还是ListTray。
 * 只是简单的调用item.makeHTML。
 * 这里不能使用switch语句或者是if语句进行判断变量item中保存的实例类型，否则就是非面向对象编程了。
 *
 * 变量item是Item类型，而Item类有声明了makeHTML方法,而且ListLink类和ListTray类都是Item类的子类。
 * 因此可以放心的调用，之后item会帮我们处理，至于item究竟怎么处理，只有item的实例对象知道。
 *
 *
 */
public class ListTray  extends Tray {
    public ListTray(String caption) {
        super(caption);
    }


    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption+"\n");
        buffer.append("<ul>\n");
        Iterator it  = tray.iterator();

        while (it.hasNext()){
            Item item  = (Item) it.next();
            buffer.append(item.makeHTML());
        }

        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return  buffer.toString();
    }
}
