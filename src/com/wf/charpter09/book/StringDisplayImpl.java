package com.wf.charpter09.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/29 19:48
 * @Description: 类的实现层次结构，用字符串显示的类，
 * 它不直接显示字符串，它继承了DisplayImpl,作为子类来使用rawOpen,rawPrint,rawClose方法进行显示。
 *
 */
public class StringDisplayImpl  extends DisplayImpl{

    // 要显示的字符串
    private String string;

    // 以字节单位计算出的字符串的宽度
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();

    }

    @Override
    public void rawPrint() {

        System.out.println("|"+ string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }


    private void printLine() {

        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
