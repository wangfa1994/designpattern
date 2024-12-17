package com.wf.charpter02.book.objectadapter;

/**
 * @Author: wangfa
 * @Date: 2019/9/29 17:56
 * @Description: 适配器
 */
public class PrintBanner extends Print {


    private Banner banner;


    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    void printWeak() {

        banner.showWithParen();

    }

    @Override
    void printStrong() {

        banner.showWithAster();

    }
}
