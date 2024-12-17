package com.wf.charpter15.book.pagemaker;

import java.io.IOException;
import java.io.Writer;

/**
 * @Author: wangfa
 * @Date: 2020/3/3 13:12
 * @Description:  编写HTML文件的类
 *
 * 用于编写简单地HTML页面，生成的HtmlWriter类的实例，并赋予其Writer，然后使用writer，输出HTML
 *
 */
public class HtmlWriter {

    private Writer writer;
    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    /*
    * 输出标题
     */
    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>"+title+"</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>"+title+"</h1>\n");
    }

    /**
     * 输出段落
     */
    public void paragraph(String msg) throws IOException {
        writer.write("<p>"+msg+"</p>\n");
    }

    /**
     * 输出超链接
     */
    public void link(String href,String caption) throws IOException {
        paragraph("<a href=\""+href+"\">"+caption+"</a>");
    }

    /**
     * 输出邮件地址
     */
    public void mailto(String mailaddr,String username) throws IOException {
        link("mailto:"+mailaddr,username);
    }
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }

}
