package com.wf.charpter08.book.tablefactory;

import com.wf.charpter08.book.factory.Item;
import com.wf.charpter08.book.factory.Page;

import java.util.Iterator;

/**
 * @Author: Mr.Wangf
 * @Date: 2020/2/4 17:02
 * @Description:
 */
public class TablePage extends Page {


    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    protected String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<table width=\"80%\" border=\"3\">\n");
        Iterator it = content.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            buffer.append("<tr>"+item.makeHTML()+"</tr>");
        }
        buffer.append("</table>\n");
        buffer.append("<hr><address>"+author+"</address>");
        buffer.append("<body></html>\n");

        return buffer.toString();
    }
}
