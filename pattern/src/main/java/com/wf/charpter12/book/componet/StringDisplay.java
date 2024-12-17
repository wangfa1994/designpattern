package com.wf.charpter12.book.componet;

/**
 * @Author: wangfa
 * @Date: 2019/10/28 19:28
 * @Description: 用于显示单行字符串的类
 *
 *
 */
public class StringDisplay extends Display {

    // 要现实的字符串
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        // 返回字符数
        return string.getBytes().length;
    }

    @Override
    public int getRows() {
        // 行数是1
        return 1;
    }


    @Override
    public String getRowText(int row) {
        // 仅当row为0时返回值
        if(row==0){
            return string;
        }
        return null;
    }
}
