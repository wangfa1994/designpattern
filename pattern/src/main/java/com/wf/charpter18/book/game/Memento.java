package com.wf.charpter18.book.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2020/3/11 11:49
 * @Description: 表示Gamer状态的类
 *
 *
 *
 */
public class Memento {

    // 所持有的金钱
    int money;
    // 所获得的水果 没有将money和fruits的可见性设置为private，是因为我们希望同在game包下的Gamer类可以访问
    ArrayList fruits;

    /**
     * 没有public，是因为只准许在同一个包下的其他类才能调用memento的构造生成实例，(Gamer类才能使用)
     * wide interface
     */
     Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    /**
     *  narrow interface 获取当前金额
     */
    public int getMoney() {
        return money;
    }

    /**
     * 获取当前所持有的水果 wide interface
     */
     List getFruits() {
        return (List)fruits.clone();
    }

    /**
     *  只允许同一个包下的其他类添加水果，因为无法从game包外部改变memento内部的状态
     *
     *  wide interface
     */
     void addFruit(String fruit){
        fruits.add(fruit);
    }
}
