package com.wf.charpter12.book.componet;

/**
 * @Author: wangfa
 * @Date: 2019/10/28 19:27
 * @Description: 用于显示字符串的抽象类
 */
public abstract class Display {

    // 获取横向字符数
    public abstract int getColumns();

    // 获取纵向字符数
    public abstract int getRows();

    // 获取第row行的字符串
    public abstract String getRowText(int row);

    // 展示
    public void show(){
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
