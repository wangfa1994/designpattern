package com.wf.charpter17.book;

import java.util.Random;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 17:02
 * @Description: 生成随机数
 *
 *
 */
public class RandomNumberGenerator extends NumberGenerator {

    private Random random  = new Random();
    // 当前数值
    private int currentNumber;

    @Override
    public int getNumber() {
        return currentNumber;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            currentNumber = random.nextInt(50);
            notifyObservers();
        }
    }
}
