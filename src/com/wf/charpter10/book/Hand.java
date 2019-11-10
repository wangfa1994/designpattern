package com.wf.charpter10.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/5 19:21
 * @Description: 猜拳中的手势类
 *
 * 在该类的内部，用int表示所出的手势，其中0表示石头1表示剪刀2表示布，并将值保存在handValue字段中。
 * 我们需要3个handler类的实例，在程序开始，我们创建三个实例并将他们保存在hand数组中。
 * Hand类的实例可以通过使用类方法getHand方法来获取，只要将表示手势的值传递给方法，它就将手势对应的Hand类的实例返回我们，(这也是一种singleton模式)。
 * isStrongThan和isWeakThan方法用于判断猜拳结构
 */
public class Hand {

    // 石头剪刀布常量 -->石头0  剪1  刀布2
    public static final int HANDVALUE_GUU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;

    // 表示猜拳中的三种手势实例
    public static final Hand[] hand = {new Hand(HANDVALUE_GUU),new Hand(HANDVALUE_CHO),new Hand(HANDVALUE_PAA)};

    // 表示猜拳中手势所对应的字符串
    private static final String[] name ={"石头","剪刀","布"};

    // 猜拳中手势的值
    private int handValue;


    public Hand(int handValue) {
        this.handValue = handValue;
    }


    public static Hand getHand(int handValue){
        return hand[handValue];
    }

    // 如果this胜了h,则返回true
    public boolean isStrongThan(Hand h){
        return fight(h)==1;
    }

    //如果this输给了h，则返回true
    public boolean isWeakerThan(Hand h){
        return fight(h) == -1;
    }

    /** 计分 平0 胜1 负-1
     * 如果this的手势值+1后是h的手势，那么就判断this获胜，之所以使用%运算符进行取余数计算，是希望布(2)加一后变成石头(0)
     */
    private int fight(Hand h) {
        if(this == h){
            return 0;
        }else if((this.handValue+1)%3 == h.handValue){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return name[handValue];
    }
}
