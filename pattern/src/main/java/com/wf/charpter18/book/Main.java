package com.wf.charpter18.book;

import com.wf.charpter18.book.game.Gamer;
import com.wf.charpter18.book.game.Memento;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wangfa
 * @Date: 2020/3/11 11:02
 * @Description: memento模式
 *
 * 备忘录模式---->保存对象状态
 *
 * 文本编辑器的撤销功能，
 * 使用面向对象编程的方式实现撤销功能，需要事先保存实例的相关状态信息，
 * 然后，在撤销的时候，还需要根据所保存的信息将实例恢复至原来的状态。
 * 想要恢复实例，需要一个可以自由访问实例内部结构的权限。但是，如果稍不注意，又可能会将依赖于实例内部结构的代码
 * 分散的编写在程序中的各个地方，导致程序变得难以维护。这种情况，就叫做破坏了封装性。
 * 通过引入表示实例状态的角色，可以在保存和恢复实例时有效的防止对象的封装性遭到破坏。这就是memento模式
 * 实现功能: 撤销(Undo)，重做(Redo)，历史记录(History)，快照(Snapshot)
 */
public class Main {


    /**
     * 游戏是自动进行的
     * 游戏的主人公通过掷骰子来决定下一个状态
     * 当骰子的点数为1的时候，主人公的金钱会增加
     * 当骰子的点数为2的时候，主人公的金钱会减少
     * 当骰子的点数为6时时候，主人公会得到水果
     * 主人公没钱时，游戏结束
     *
     * 当金钱增加时，为了方便状态恢复，生成memento实例，将当前状态保存起来，所保存的是金钱和水果，
     * 如果不断抛出金钱减少的点数，为了防止金钱变成0，而导致游戏结束，我们会将游戏恢复至之前的状态。
     */


    public static void main(String[] args) {

        Gamer gamer = new Gamer(100);
        // 保存最初状态
        Memento memento = gamer.createMemento();
        for (int i = 0; i <100; i++) {

            System.out.println("======"+i);
            System.out.println("当前状态:"+gamer);
            // 开始游戏
            gamer.bet();

            System.out.println("所持有的金钱为"+gamer.getMoney());

            // 决定如何处理memento
            if(gamer.getMoney()>memento.getMoney()){
                System.out.printf("金钱增加了变多，保存状态");
                memento = gamer.createMemento();
            }else if(gamer.getMoney()<memento.getMoney()/2){
                System.out.printf("金钱变少了许多，恢复至以前的状态");
                gamer.restoreMemento(memento);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");

        }
    }

}
