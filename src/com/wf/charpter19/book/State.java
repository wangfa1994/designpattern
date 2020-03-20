package com.wf.charpter19.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/12 10:38
 * @Description: 表示金库状态的接口
 *
 */
public interface State {

    /**
     * 设置时间
     */
    void doLock(Context context,int hour);
    /**
     * 使用金库
     */
    void doUser(Context context);
    /**
     * 按下警铃
     */
    void doAlarm(Context context);
    /**
     * 正常通话
     */
    void doPhone(Context context);
    /**
     * 这些方法的处理，都会根据状态不同而不同，此接口可以说是一个依赖于状态的方法的集合
     * 这些方法的参数Context是管理状态的接口
     */
}
