package com.wf.charpter13.book;

import com.wf.charpter13.book.composite.Directory;
import com.wf.charpter13.book.composite.Entry;
import com.wf.charpter13.book.composite.File;

import java.util.Iterator;

/**
 * @Author: wangfa
 * @Date: 2020/2/12 15:44
 * @Description:Visitor类的子类，作用是访问数据结构并且显示元素一览
 */
public class ListVisitor extends Visitor {

    private String currentdir="";

    @Override
    public void visit(File file) {
        System.out.println(currentdir+"/"+file);

    }


    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir+"/"+directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator it  = directory.iterator();
        while (it.hasNext()){
            Entry next = (Entry) it.next();
            next.accept(this);
        }
        currentdir = savedir;
    }
}
