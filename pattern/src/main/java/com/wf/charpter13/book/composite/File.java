package com.wf.charpter13.book.composite;

import com.wf.charpter13.book.Visitor;

/**
 * @Author: wangfa
 * @Date: 2020/2/5 18:01
 * @Description: 表示文件的类,是Entry类的子类
 */
public class File extends Entry {

    private String fileName;
    private int fileSize;


    public File(String name, int size) {
        this.fileName = name;
        this.fileSize = size;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public int getSize() {
        return fileSize;
    }


    @Override
    /**
     * 相当于访问的是File
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
