package com.wf.charpter16.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 14:08
 * @Description: 仲裁者接口的API
 *表示仲裁者的接口，具体的仲裁者会实现这个接口
 */
public interface Mediator {

    /**
     * 用于生成Mediator要管理的组员
     */
    void createColleagues();

    /**
     * 此方法会被各个Colleague组员调用，他的作用是让组员可以向仲裁者进行报告
     */
    void colleagueChanged();
}
