package com.wf.charpter10.book;

import java.util.Random;

/**
 * @Author: wangfa
 * @Date: 2019/11/5 19:32
 * @Description: 策略实现类---->根据上一局的手势从概率上计算出下一局的手势，
 *                            从之前的猜拳结果计算下一局出各种拳的概率
 *
 *
 * history字段是一个表，被用于计算根据过去的胜负来进行概率计算，
 * 他是一个二维数组，history[上一局出的手势][这一局出的手势]
 * 这个表达式的值越大，表示过去的胜率越高，
 */
public class ProbStrategy  implements Strategy{

    private Random random;
    private int preHandValue = 0;
    private int currentHandValue = 0;

    private int [][] history = {
            {1,1,1, },
            {1,1,1, },
            {1,1,1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }



    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if(bet < history[currentHandValue][0]){
            handValue = 0;

        }else if(bet<history[currentHandValue][0] +history[currentHandValue][1]){
            handValue= 1;
        }else {
            handValue = 2;
        }

        preHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    private int getSum(int currentHandValue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[currentHandValue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if(win){
            history[preHandValue][currentHandValue]++;
        }else {
            history[preHandValue][(currentHandValue+1) % 3] ++;
            history[preHandValue][(currentHandValue+2) % 3] ++;
        }

    }
}
