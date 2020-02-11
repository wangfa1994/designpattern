package com.wf.charpter12.book;

import com.wf.charpter12.book.componet.Display;
import com.wf.charpter12.book.componet.StringDisplay;
import com.wf.charpter12.book.decorator.FullBorder;
import com.wf.charpter12.book.decorator.SideBorder;

/**
 * @Author: wangfa
 * @Date: 2019/10/28 19:26
 * @Description:  Decorator模式
 * 装饰者模式----->装饰边框与被装饰物的一致性
 *
 * 假设有一个块蛋糕，涂上奶油其他什么都不加，就是奶油蛋糕，如果再加上草莓，就是草莓奶油蛋糕，
 * 不论是蛋糕，奶油蛋糕，草莓奶油蛋糕，他们的核心都是蛋糕，经过涂上奶油，加上草莓等装饰后，蛋糕的味道变得更甜美了
 *
 * 像这样不断的为对象添加装饰的设计模式叫做Decorator模式。
 *
 *
 *
 */

public class Main {



    /**
     * 给文字添加装饰边框，装饰边框是指"-","+","|"等字符串组成的边框
     *
     *
     * Display 用来显示字符串的抽象类
     * StringDisplay 用于显示单行字符串的类
     *
     * Border 用于显示装饰边框的抽象类
     * SideBorder 用于只显示左右边框的类
     * FullBorder 用于显示上下左右边框的类
     *
     *
     * **/
    public static void main(String[] args) {

        Display b1 = new StringDisplay("Hello world.");
        Display b2 = new SideBorder(b1,'#');
        Display b3 = new FullBorder(b2);
        b1.show();
        System.out.println();
        b2.show();
        System.out.println();
        b3.show();
        System.out.println();
        // 给文字添加多重边框
        Display b4 = new SideBorder(new FullBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("hello,world")),'*'))),'/');
        b4.show();

    }
}
