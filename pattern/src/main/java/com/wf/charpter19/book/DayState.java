package com.wf.charpter19.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/12 10:38
 * @Description: 表示白天状态的类
 */
public class DayState  implements State{

    /**
     * 单例模式，获取唯一实例
     */
    private static DayState dayState = new DayState();
    private DayState() {}
    public static DayState getInstance(){return dayState;}

    /**
     * 设置时间
     */
    @Override
    public void doLock(Context context, int hour) {
        if(hour<9||hour>=17){
            context.changeState(NightState.getInstance());
        }
    }

    /**
     * 使用金库
     */
    @Override
    public void doUser(Context context) {
        context.recording("使用金库(白天)");
    }

    /**
     * 按下警铃

     */
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(白天)");
    }

    /**
     * 正常通话
     */
    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话(白天)");

    }

    @Override
    public String toString() {
        return "白天";
    }
}
