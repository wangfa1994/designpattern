package com.wf.charpter08.book.factory;

/**
 * @Author: wangfa
 * @Date: 2019/11/17 14:46
 * @Description: factory包:包含抽象工厂，零件，产品的包
 * 表示抽象工厂的类
 *
 * 抽象零件(Item,Link,Tray)和抽象产品(Page)
 *
 * getFactory方法可以根据指定的类名生产具体工厂的实例。
 * 虽然getFactory方法生成的是具体工厂的实例，但是返回值的类型是抽象工厂类型
 *
 * createLink，createTray，createPage方法是用于在抽象工厂中生成零件和产品的方法
 * 这些方法都是抽象的，具体的实现时交给Factory子类
 */
public abstract class Factory {

    public static Factory getFactory(String className){
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(className).newInstance();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption,String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title,String author);
}
