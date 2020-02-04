package com.wf.charpter07.book;

import java.util.Scanner;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 21:39
 * @Description: Builder模式
 * 建造者模式------>组装复杂的实例
 *
 * 在构建大楼的时候，需要先打地基，搭建框架，然后一层一层的盖起来。
 * 通常，在建造这种具有复杂结构的物体时，很难一气呵成，
 * 我们需要首先建造组成这个物体的各个部分，然后分阶段将他们组装起来。(定义不同的方法，表示建造不同的物体)
 *
 * 组装具有复杂结构的实例的builder模式
 *
 *
 *
 *
 */
public class Main {


    /**
     * 使用Builder模式编写"文档"的程序。这里编写的文档具有以下结构
     *  1. 含有一个标题
     *  2. 含有几个字符串
     *  3. 含有条目项目
        Builder 类中定义了决定文档结构的方法，然后director类使用该方法编写一个具体的文档
        Builder 是抽象类，他并没有进行任何实际的处理，仅仅声明了抽象方法，
        Builder 类的子类决定了用来编写文档的具体处理。(TextBuilder类使用纯文本进行编写，HTML类:使用HTML编写文档)
     */
    public static void main(String[] args) {

        System.out.println("请输入plain 或者 html");
        Scanner scanner = new Scanner(System.in);
        String input= scanner.next();



        // 文本
        if("plain".equals(input)){
            //创建文本的建造者，传递给我们的Director，进行文档的编写
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

    /**
     * Director(导向器)并不关心实际编写的文档到底是TextBuilder还是HTMLBuilder。
     * 正是因为如此，我们必须在Builder中声明足够多的方法，以实现编写文档的功能，
     * 但是，并不包括TextBuilder和HTMLBuilder中特有的方法。
     */


    private static void usage() {
        System.out.println("Usage: java Main plain 编写纯文本文档");
        System.out.println("Usge：java Main 编写HTML 文档");
    }


}
