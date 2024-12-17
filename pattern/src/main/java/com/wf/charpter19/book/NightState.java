package com.wf.charpter19.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/12 10:38
 * @Description: 表示晚上状态的类
 */
public class NightState  implements  State{
    /**
     * 单例模式，获取唯一实例
     */
    private static NightState nightState = new NightState();
    private NightState() {}
    public static NightState getInstance(){return nightState;}


    /**
     * 设置时间
     */
    @Override
    public void doLock(Context context, int hour) {
        if(hour>=9&&hour<17){
            context.changeState(DayState.getInstance());
        }
    }

    /**
     * 使用金库
     */
    @Override
    public void doUser(Context context) {
        context.callSecurityCenter("使用金库(晚上)");
    }

    /**
     * 按下警铃

     */
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(晚上)");
    }

    /**
     * 正常通话
     */
    @Override
    public void doPhone(Context context) {
        context.recording("晚上的通话录音");

    }

    @Override
    public String toString() {
        return "晚上";
    }
}
