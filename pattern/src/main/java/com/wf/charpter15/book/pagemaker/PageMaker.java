package com.wf.charpter15.book.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: wangfa
 * @Date: 2020/3/3 13:13
 * @Description: 根据邮件地址，编写用户的Web页面
 *
 * 使用Database 和 HtmlWriter 类来生成指定用户的web页面
 * 该类中只有一个方法，会根据指定的邮件地址和文件名生成对应的web页面
 *
 * 该类一手包办了调用HtmlWriter类的方法的这一工作，对外部他只提供了makeWelcomePage接口，这就是一个简单窗口
 */
public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr,String filename)  {

       try {
           Properties mailprop = Database.getProperties("maildata");
           String username = mailprop.getProperty(mailaddr);
           HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
           writer.title("welcome to "+username+"'s page");
           writer.paragraph(username+"欢迎来到"+username+" 的主页。");
           writer.paragraph("等着你的邮件哦");
           writer.mailto(mailaddr,username);
           writer.close();
           System.out.printf(filename+"is created for"+mailaddr+"("+username+")");

       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
