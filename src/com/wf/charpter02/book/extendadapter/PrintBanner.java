package com.wf.charpter02.book.extendadapter;

/**
 * @Author: wangfa
 * @Date: 2019/9/28 17:19
 * @Description: 变换装置(适配器)
 *
 * 继承了Banner类，继承了 showWithParent 和showWithAster方法
 * 实现了Print接口，实现了printWeak 和 printStrong 方法
 *
 */
public class PrintBanner extends Banner implements Print {


    public PrintBanner(String string) {
        super(string);
    }



    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }

}
