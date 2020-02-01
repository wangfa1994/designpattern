package com.wf.charpter08.book.listfactory;

import com.wf.charpter08.book.factory.Link;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:53
 * @Description: 具体零件:表示HTML 的链接的类
 *
 * ListLink类是Link的子类，在ListLink类中必须实现的方法是在父类声明的makeHTML抽象方法。
 * ListLink类使用li和a标签来制作HTML片段，
 * 这段HTML片段也可以与ListTray和ListPage的结果合并起来，就如同将螺母和螺栓拧在一起
 */
public class ListLink  extends Link{

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li> <a href = \""+url+ "\">" + caption + "</a></li>\n";

    }
}
