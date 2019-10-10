package com.wf.charpter03.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/8 19:01
 * @Description:
 *
 * template method 模式是带有模板功能的模式。
 * 组成模板的方法被定义在父类，由于这些方法是抽象的，所以在只查看父类的代码是无法知道这些方法最终会进行何种具体的处理，
 * 唯一能知道的就是父类如何调用这些方法的。
 *
 * 实现抽象方法的子类也就决定了具体的处理---->只要在不同的子类中实现不同的具体处理，当父类的模板方法被调用时程序的行为也会不同，
 * 但是处理的流程都会按照父类中所定义的那样进行。
 */
public class Main {




    public static void main(String[] args) {

        /**
         *
         * @Author: wangfa
         * @Date: 2019/10/8 下午7:22
         * @Description: 将字符和字符串循环输出五次
         */

        AbstractDisplay charDisplay = new CharDisplay('H');
        charDisplay.display();

        AbstractDisplay stringDisplay01 = new StringDisplay("Hello,world.");
        stringDisplay01.display();



        AbstractDisplay stringDisplay = new StringDisplay("你好，世界。");
        stringDisplay.display();
    }
}
