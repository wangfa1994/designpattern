package com.wf.charpter08.book.listfactory;

import com.wf.charpter08.book.factory.Item;
import com.wf.charpter08.book.factory.Page;

import java.util.Iterator;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:54
 * @Description: 具体产品: 表示HTML页面的类
 * <p>
 * <p>
 * ListPage类是Page的子类，ListPage将字段中保存的内容输出为HTML格式
 * <p>
 * while语句被放在<ul></ul>之间，
 * 是因为在while语句中append的item.makeHTML()的输出结果需要被嵌入在
 * <ul></ul>之间。
 */
public class ListPage extends Page {


    public ListPage(String title, String author) {
        super(title, author);
    }


    @Override
    protected String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<ul>\n");
        Iterator it = content.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>"+author+"</address>");
        buffer.append("<body></html>\n");

        return buffer.toString();
    }
}
