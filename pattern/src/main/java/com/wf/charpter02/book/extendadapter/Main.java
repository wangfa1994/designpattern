package com.wf.charpter02.book.extendadapter;

/**
 * @Author: wangfa
 * @Date: 2019/9/28 17:26
 * @Description: 使用继承的适配器
 *
 *
 */
public class Main {


    /**
     * 将输入字符串显示为(Hello) 或者 *Hello* 的程序
     */

    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();

        /**
         *
         * 通过适配器角色PrintBanner类来弱化或者强化字符串的展示
         *
         * 将PrintBanner类的实例保存在Print类型的变量中，我们是使用Print接口来进行编程的。
         * 对于Main来说，Banner类，showWithParen方法和showWithAster方法被完全隐藏起来
         * 好比笔记本电脑只要12V的电压，但是他不知道12电压是由适配器将100V的转换而成的
         * 由于Main类并不知道PrintBanner类是如何实现的，这样就可以再不用对Main类进行修改的情况下改变PrintBanner类的具体实现
         *
         */
    }
}
