package com.wf.charpter12.book.decorator;

import com.wf.charpter12.book.componet.Display;

/**
 * @Author: wangfa
 * @Date: 2019/10/28 19:35
 * @Description:  用于只显示左右边框的类
 */
public class SideBorder extends Border {

    // 表示装饰边框的字符
    private char borderChar;

    // 通过构造函数指定display和装饰边框字符
    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        // 字符数为字符串字符数加上两侧边框字符数
        return 1+display.getColumns()+1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row)+ borderChar;
    }
}
