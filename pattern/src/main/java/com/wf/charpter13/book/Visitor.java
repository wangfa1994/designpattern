package com.wf.charpter13.book;

import com.wf.charpter13.book.composite.Directory;
import com.wf.charpter13.book.composite.File;

/**
 * @Author: wangfa
 * @Date: 2020/2/12 15:36
 * @Description: 表示访问者的抽象类，访问者依赖于它访问数据结构
 */
public abstract class Visitor {

    public  abstract void visit(File file);

    public abstract void visit(Directory directory);


}
