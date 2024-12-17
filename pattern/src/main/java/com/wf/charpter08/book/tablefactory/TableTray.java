package com.wf.charpter08.book.tablefactory;

import com.wf.charpter08.book.factory.Item;
import com.wf.charpter08.book.factory.Tray;

import java.util.Iterator;

/**
 * @Author: Mr.Wangf
 * @Date: 2020/2/4 17:02
 * @Description:
 */
public class TableTray extends Tray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");

        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\""+tray.size()+"\"><b>"
                + caption +"</b></td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        Iterator it  = tray.iterator();

        while (it.hasNext()){
            Item item  = (Item) it.next();
            buffer.append(item.makeHTML());
        }

        buffer.append("</tr></table>");

        buffer.append("</td>");
        return  buffer.toString();
    }
}
