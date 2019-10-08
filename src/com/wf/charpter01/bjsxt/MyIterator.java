package com.wf.charpter01.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/9/29 16:23
 * @Description:
 */
public interface MyIterator {


    /**
     *
     * @Author: wangfa
     * @Date: 2019/9/29 下午4:25
     * @Description: 将游标指向第一个元素
     */
    void first();

    /**
     *
     * @Author: wangfa
     * @Date: 2019/9/29 下午4:25
     * @Description: 将游标指向下一个元素
     */
    void next();



    boolean hasNext();


    boolean isFirst();
    boolean isEnd();

    Object getCurrentObject();
}
