package com.wf.charpter10.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/5 19:16
 * @Description: strategy 模式
 * 策略模式----->整体替换算法
 *
 * 无论什么程序，其主要目的都是解决问题，而为了解决问题，我们有需要编写特定的算法
 * 使用strategy模式可以整体的替换算法的实现部分。
 * 能够整体的替换算法，能让我们轻松的以不同的算法去解决一个问题。
 */
public class Main {


    /**
     *
     * 电脑玩猜拳游戏
     * 我们考虑了两种猜拳的策略，
     * 第一种策略是如果这局猜拳成功，name下一局也出一样的手势(WinningStrategy)
     * 第二种策略是根据上一局的手势从概率上计算出下一局的手势
     */
    public static void main(String[] args) {


        //

        if(args.length != 2){
            System.out.println("Usage：java Main randomseed1 randomseed2");
            System.out.println("examlpe: java main 314 315");
            System.exit(0);
        }else{
            int seed1 = Integer.valueOf(args[0]);
            int seed2 = Integer.parseInt(args[1]);
            Player player1 = new Player("Taro",new WinningStrategy(seed1));
            Player player2 = new Player("Hana",new ProbStrategy(seed2));
            for (int i = 0; i < 100; i++) {

                Hand nextHand1 = player1.nextHand();
                Hand nextHand2 = player2.nextHand();

                if(nextHand1.isStrongThan(nextHand2)){
                    System.out.println("Winner:"+player1);
                    player1.win();
                    player2.lose();
                }else if (nextHand2.isStrongThan(nextHand1)){
                    System.out.println("Winner:"+player2);
                    player1.lose();
                    player2.win();
                }else{
                    System.out.println("even");
                    player1.even();
                    player2.even();
                }
            }
            System.out.println("Total result:");
            System.out.println(player1.toString());
            System.out.println(player2.toString());
        }
    }

}
