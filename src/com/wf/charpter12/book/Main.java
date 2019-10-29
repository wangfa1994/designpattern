package com.wf.charpter12.book;

import com.wf.charpter12.book.componet.Display;
import com.wf.charpter12.book.componet.StringDisplay;
import com.wf.charpter12.book.decorator.FullBorder;
import com.wf.charpter12.book.decorator.SideBorder;

/**
 * @Author: wangfa
 * @Date: 2019/10/28 19:26
 * @Description: 装饰者模式
 */

public class Main {



    // 给文字添加边框
    public static void main(String[] args) {

        Display b1 = new StringDisplay("Hello world.");
        Display b2 = new SideBorder(b1,'#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();

        // 给文字添加多重边框
        Display b4 = new SideBorder(new FullBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("hello,world")),'*'))),'/');
        b4.show();

    }
}
