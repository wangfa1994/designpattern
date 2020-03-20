package com.wf.charpter19.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/12 10:25
 * @Description:  state模式
 *
 * 状态模式----->用类表示状态
 *用类表示状态后，就可以通过切换类来方便的改变对象的状态，当需要增加新的状态时，如何修改代码也是很明确的
 *
 */
public class Main {

    /**
     * 金库报警系统:警戒状态每小时会改变一次
     *
     * 有一个金库，金库与警报中心相连，
     * 金库有警铃与正常通话使用的电话
     * 金库有时钟，监视现在的时间
     *白天时间范围9:00-16:59 晚上时间是17:00-23:59 00:00-8:59
     *
     * 金库只能白天使用，白天使用会在警报中心留下记录，晚上使用金库，向报警中心发送紧急事态通知
     *
     * 任何时候都可以使用警铃，使用警铃会向报警中心发送紧急事态通知
     *
     * 任何时候都可以使用电话，白天使用会呼叫报警中心，晚上使用电话会呼叫报警中心的留言电话
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {
        SafeFrame safeFrame = new SafeFrame("状态模式");
        while (true){
            for (int hour=0;hour<24;hour++){
                safeFrame.setClock(hour);
                Thread.sleep(2000);
            }
        }
    }
}
