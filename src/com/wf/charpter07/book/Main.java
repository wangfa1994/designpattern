package com.wf.charpter07.book;

import java.util.Scanner;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 21:39
 * @Description: 组装复杂的实例
 */
public class Main {


    /**
     * 使用Builder模式编写"文档"的程序。这里编写的文档具有以下结构
     *  1. 含有一个标题
     *  2. 含有几个字符串
     *  3. 含有条目项目
        Builder 类中定义了决定文档结构的方法，然后director类使用该方法编写一个具体的文档
        Builder 是抽象类，他并没有进行任何实际的处理，仅仅声明了抽象方法，
        Builder 类的子类决定了用来编写文档的具体处理。
     */
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String input= scanner.next();

        // 文本
        if("plain".equals(input)){
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        }else if("html".equals(input)){
            HTMLBuilder htmlBuilder  = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName+"文件编写完成");
        }else{
            usage();
            System.exit(0);
        }

    }


    private static void usage() {
        System.out.println("Usage: java Main plain 编写纯文本文档");
        System.out.println("Usge：java Main 编写HTML 文档");
    }


}
