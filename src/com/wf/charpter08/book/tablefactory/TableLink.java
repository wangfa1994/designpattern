package com.wf.charpter08.book.tablefactory;

import com.wf.charpter08.book.factory.Link;

/**
 * @Author: Mr.Wangf
 * @Date: 2020/2/4 17:01
 * @Description:
 */
public class TableLink  extends Link{

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<td> <a href = \""+url+ "\">" + caption + "</a></td>\n";
    }
}
