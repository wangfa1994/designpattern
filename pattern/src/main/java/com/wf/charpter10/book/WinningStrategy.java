package com.wf.charpter10.book;

import java.util.Random;

/**
 * @Author: wangfa
 * @Date: 2019/11/5 19:32
 * @Description: 策略实现类-->如果本次猜拳获胜，则下次也出相同的手势,如果本次输了，则下一局随机
 */
public class WinningStrategy  implements Strategy{

    private Random random;
    private  boolean won = false;

    private Hand preHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if(!won){
            preHand = Hand.getHand(random.nextInt(3));
        }
        return preHand;
    }

    @Override
    public void study(boolean win) {
            won = win;
    }
}
