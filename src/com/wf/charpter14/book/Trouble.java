package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 18:02
 * @Description: 表示发生问题的类，number是问题编号，通过getNumber方法可以获取问题编号
 */
public class Trouble {

    // 问题编号
    private int number;


    // 生成问题
    public Trouble(int number) {
        this.number = number;
    }

    // 获取问题编号
    public int getNumber() {
        return number;
    }


    @Override
    public String toString() {
        return "[Trouble"+ number+"]";
    }
}
