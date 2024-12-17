package com.wf.charpter03.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/8 19:02
 * @Description: 字符展示
 */
public class CharDisplay extends AbstractDisplay {

    /**
     * 需要展示的字符，构造函数中接受到 的字符被保存在字段中进行展示
     */
    private char ch;
    public CharDisplay(char ch) {
        this.ch = ch;
    }


    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
