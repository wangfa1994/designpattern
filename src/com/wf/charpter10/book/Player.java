package com.wf.charpter10.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/5 19:36
 * @Description: 表示进行猜拳游戏的选手的类
 * <p>
 * 在生成Player类的实例时，需要向其传递姓名和策略，
 * nextHand方法是用来获取下一局手势的方法，不过实际上决定下一局手势的是各个策略，返回值实际就是策略的nextHand方法的返回值。
 * nextHand方法将自己的工作委托给了Strategy，这就形成了一种委托模式
 * <p>
 * 在决定下一局要出的手势时，需要知道之前各局的胜(win)平(even)负(lose)结果。
 * Player类会通过strategy字段调用study方法，
 * 然后study方法会改变策略的内部状态，wincount,losecount和gamecount,用于记录猜拳结果
 */
public class Player {

    private String name;

    private Strategy strategy;

    private int wincount;
    private int losecount;
    private int gamecount;

    // 赋予名字和策略
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }


    // 策略决定下一局要出的手势
    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {  // 胜
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    public void lose() {  //负
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    public void even() { // 平
        gamecount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", wincount=" + wincount +
                ", losecount=" + losecount +
                ", gamecount=" + gamecount +
                '}';
    }
}
