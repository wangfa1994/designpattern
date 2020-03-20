package com.wf.charpter19.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/12 10:39
 * @Description: 表示管理金库的状态，并且与警报中心联系的接口
 */
public interface Context {

    /**
     * 设置时间
     */
    void setClock(int hour);
    /**
     * 改变状态
     */
    void changeState(State state);
    /**
     *联系报警中心
     */
    void callSecurityCenter(String msg);
    /**
     *在报警中心留下记录
     */
    void recording(String msg);
}
