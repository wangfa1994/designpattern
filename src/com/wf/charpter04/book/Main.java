package com.wf.charpter04.book;

import com.wf.charpter04.book.framework.Factory;
import com.wf.charpter04.book.framework.Product;
import com.wf.charpter04.book.idcard.IDCardFactory;

/**
 * @Author: wangfa
 * @Date: 2019/10/9 19:04
 * @Description:
 *
 * 用template Method 模式来构建生成实例的工厂，这就是factory method 模式
 *
 * 在factory method 模式中，父类决定实例的生成方式，但并不决定所要生成的具体类，具体的处理全交给子类负责。
 *
 * 可以将生成实例的框架(framework)和实际负责生成实例的类解耦
 */
public class Main {


    /**
     *  制作身份证
     *
     *  生成实例的框架(framework)
     *  加工处理(idcard)
     */
    public static void main(String[] args) {

        Factory factory = new IDCardFactory();

        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");

        card1.use();
        card2.use();
        card3.use();


    }

}
