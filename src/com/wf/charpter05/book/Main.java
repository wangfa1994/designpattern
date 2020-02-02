package com.wf.charpter05.book;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 09:14
 * @Description:
 *  单例类，只生成一个实例
 *
 */
public class Main {


    public static void main(String[] args) {

        Singleton singleton01 = Singleton.getInstance();
        Singleton singleton02 = Singleton.getInstance();

        if(singleton01 == singleton02){
            System.out.println("相同实例");
        }else{
            System.out.println("不同实例");
        }

    }
}
