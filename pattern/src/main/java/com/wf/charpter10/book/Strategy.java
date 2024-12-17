package com.wf.charpter10.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/5 19:21
 * @Description: 猜拳游戏中的策略类
 *
 * 定义了猜拳策略的抽象方法的接口
 *
 */
public interface Strategy {


    // 获取下一局要出的手势，调用该方法后，实现了Strategy接口的类就会绞尽脑汁想出下一局出什么手势
    Hand nextHand();

    //学习上一局的手势是否获胜了，
    //如果在上一局中调用nextHand获胜了,就接着调用study(true),如果输了，就接着调用study(false)。
    //Strategy接口的实现类就会改变自己的内部状态，从而为下一次nextHand被调用时究竟是返回石头剪刀还是布提供判断依据。
    void study(boolean win);
}
