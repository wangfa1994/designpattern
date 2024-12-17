package com.wf.charpter02.book.objectadapter;

import com.wf.charpter02.book.extendadapter.Print;
import com.wf.charpter02.book.extendadapter.PrintBanner;

/**
 * @Author: wangfa
 * @Date: 2019/9/28 17:26
 * @Description: 使用委托的适配器
 *
 *
 */
public class Main {


    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");


        print.printStrong();
        print.printWeak();
    }
}
