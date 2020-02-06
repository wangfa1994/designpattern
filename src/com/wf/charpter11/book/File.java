package com.wf.charpter11.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/5 18:01
 * @Description: 表示文件的类,是Entry类的子类
 */
public class File extends Entry{

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
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
