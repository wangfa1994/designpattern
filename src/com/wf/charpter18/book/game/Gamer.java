package com.wf.charpter18.book.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Author: wangfa
 * @Date: 2020/3/11 11:49
 * @Description: 表示游戏主人公的类，会生成Memento实例
 */
public class Gamer {

    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsname ={"苹果","橘子","香蕉","葡萄"};


    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet(){
        int dice = random.nextInt(6)+1;
        if(dice==1){
            money+=100;
            System.out.println("所持有金钱增加了");
        }else if (dice == 2){
            money/=2;
            System.out.println("所持有金钱减半了");
        }else if (dice ==6){
            String f = getFruit();
            System.out.println("获得了水果:"+f);
            fruits.add(f);
        }else{
            System.out.println("什么都没有发生");
        }
    }


    /*
    * 保存当前的状态(拍摄快照)，会根据当前时间点所持有的金钱和水果生成一个memento，代表当前的状态，他会返回给调用者。
    * 就如同给对象照了一张照片，将对象保存在memento中，
    *
     */
    public Memento createMemento(){
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()){
            String  f = (String)it.next();
            if(f.startsWith("好吃的")){
                m.addFruit(f);
            }
        }
        return m;
    }

    /**
     * 根据收到的memento实例，将当前对象恢复到备忘录状态
     */
    public void restoreMemento(Memento memento){
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }
    private String getFruit(){
        String prefix = "";
        if(random.nextBoolean()){
            prefix = "好吃的";
        }
        return  prefix+fruitsname[random.nextInt(fruitsname.length)];
    }
}
