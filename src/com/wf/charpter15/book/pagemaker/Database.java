package com.wf.charpter15.book.pagemaker;

import com.wf.charpter15.book.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: wangfa
 * @Date: 2020/3/3 13:10
 * @Description: 从邮件中获取用户名的类
 *
 *获取指定的数据库名(maildata)所对应的的Properties的实例
 * 我们无法创建该类的实例，只能通过getProperties来获取对应的Properties的实例
 */
public class Database {

    /**
     * 构造函数私有化，防止外部创建类
     */
    private Database() {}


    /**
     * 根据数据库名，获取对应的Properties
     */
    public static Properties getProperties(String dbname){

    String fileName = dbname+".txt";
        Properties properties = new Properties();
        try {
           // properties.load(new FileInputStream(fileName));
            properties.load(Main.class.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
