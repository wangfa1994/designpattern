package com.wf.charpter11.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2020/2/5 18:05
 * @Description: 表示文件夹的类
 */
public class Directory  extends Entry{

    private String  directoryName;

    private ArrayList directory = new ArrayList();


    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public String getName() {
        return directoryName;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            size += entry.getSize();
        }
        return size;
    }


    @Override
    public Entry add(Entry entry) throws FileTreatementException {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" +this);
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()){
            Entry entry = (Entry)iterator.next();
            entry.printList(prefix+"/"+directoryName);
        }
    }
}
