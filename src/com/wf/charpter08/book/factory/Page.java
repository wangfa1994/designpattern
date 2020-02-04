package com.wf.charpter08.book.factory;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:52
 * @Description: 抽象产品:表示HTML页面的类
 *
 * Page类是抽象地表示HTML页面的类，
 * 如果将Link 和 Tray 比喻成抽象的零件，那么Page类就表示产品。
 *
 * 使用add方法想页面中添加Item(即增加Link和Tray)，增加的Item将会在页面展示出来
 * output方法首先根据页面标题确定文件名，接着调用makeHTML方法将自身保存的HTML内容写入到文件中。
 *
 */
public abstract class Page {

    // 页面的标题
    protected String title;
    // 页面的作者
    protected String author;
    protected ArrayList<Item> content  =new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item){
        content.add(item);
    }

    public void output(){

        try {
            String fileName = title+".html";
            Writer writer  = new FileWriter(fileName);
            // 注意是自己的makeHTML()
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(fileName+"编写完成。");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected abstract String makeHTML();
}
