package com.wf.charpter08.book.tablefactory;

import com.wf.charpter08.book.factory.Factory;
import com.wf.charpter08.book.factory.Link;
import com.wf.charpter08.book.factory.Page;
import com.wf.charpter08.book.factory.Tray;

/**
 * @Author: Mr.Wangf
 * @Date: 2020/2/4 17:00
 * @Description:
 */
public class TableFactory extends Factory {


    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new  TablePage(title,author);
    }
}
