package com.wf.charpter06.bjsxt;

import java.io.*;
import java.util.Date;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 16:19
 * @Description: 利用序列化和反序列化进行深复制 需要对象实现Serializable
 */
public class Cilent2 {



    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Sheep sheep = new Sheep();
        Date date = new Date();

        sheep.setName("name");
        sheep.setBirthday(date);
        System.out.println("原型"+sheep+"\t 生日\t" +sheep.getBirthday());


        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(sheep);
        byte[] bytes = bos.toByteArray();

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep clone = (Sheep) ois.readObject();

        date.setTime(1234567890L);
        System.out.println("原型"+sheep+"\t 生日\t" +sheep.getBirthday()+"重新设置时间");

        System.out.println("克隆"+clone+"\t 生日\t"+clone.getBirthday());



    }
}
