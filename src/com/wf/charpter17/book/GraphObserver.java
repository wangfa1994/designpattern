package com.wf.charpter17.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 17:03
 * @Description: 表示以图形方式显示数值的类
 */
public class GraphObserver implements Observer{

    /**
     * 接收NumberGenerator的实例作为参数，然后通过调用NumberGenerator类的实例的getNumber方法获取当前的数值，
     * 并将这个数值展示出来，
     */
    @Override
    public void update(NumberGenerator numberGenerator) {

        System.out.print("Graph:");
        int count = numberGenerator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
