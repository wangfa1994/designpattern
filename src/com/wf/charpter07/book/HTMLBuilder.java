package com.wf.charpter07.book;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wangfa
 * @Date: 2019/11/3 16:41
 * @Description: 使用了HTML编写文档的类，继承了Builder类，实现了各个部分的编写的逻辑
 */
public class HTMLBuilder  extends  Builder{

    private String fileName;
    private PrintWriter writer;



    @Override
    public void makeTitle(String title) {
        fileName = title+".html";

        try {
            writer = new PrintWriter((new FileWriter(fileName)));
        }catch (IOException e){

        }
        writer.println("<html><head><title>"+title+"</title></head><body>");
        writer.println("<h1>"+title+"</h1>");
        
    }



    @Override
    public void makeString(String string) {

        writer.println("<p>"+string+"</p>");

    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (String item : items) {
            writer.println("<li>"+item+"</li>");
        }
        writer.println("</ul>");

    }

    @Override
    public void close() {
    writer.println("</body></html>");
    writer.close();
    }

    public String getResult(){
        return fileName;
    }
}
