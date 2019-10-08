package com.wf.charpter06.bjsxt;

import java.util.Date;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 16:00
 * @Description:
 */
public class Client {


    public static void main(String[] args) throws CloneNotSupportedException {
        lowClone();


    }


    // 浅克隆
    private static void lowClone() throws CloneNotSupportedException {
        // 浅克隆 复制新的地址，但是对象中的其他对象还是同一个，没有进行递归复制所有对象
        // 注意date值，java 默认浅复制
        Sheep sheep = new Sheep();
        Date date = new Date();

        sheep.setName("name");
        sheep.setBirthday(date);
        System.out.println("原型"+sheep+"\t 生日\t" +sheep.getBirthday());


        Sheep clone = (Sheep) sheep.clone();

        date.setTime(1234567890L);
        System.out.println("原型"+sheep+"\t 生日\t" +sheep.getBirthday()+"重新设置时间");

        System.out.println("克隆"+clone+"\t 生日\t"+clone.getBirthday());
    }
}
