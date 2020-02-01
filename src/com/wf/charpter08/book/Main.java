package com.wf.charpter08.book;

import com.wf.charpter08.book.factory.Factory;
import com.wf.charpter08.book.factory.Link;
import com.wf.charpter08.book.factory.Page;
import com.wf.charpter08.book.factory.Tray;

import java.util.Scanner;

/**
 * @Author: wangfa
 * @Date: 2019/11/4 19:23
 * @Description: AbstractFactory模式
 * 抽象工厂模式----->将关联零件组装成产品
 *
 *
 * 抽象工厂的工作是将抽象零件组装为抽象产品。
 * 也就是说我们不关心零件的具体实现，而是只关心接口，我们仅使用该接口将零件组装成为产品
 *
 *在模板方法模式和建造者模式中，子类这一层负责方法的具体实现，在抽象工厂模式中也是一样的。
 * 在子类这一层中有具体的工厂，他负责将具体的零件组装成具体的产品。
 *
 *
 */
public class Main {


    /**
     * 将带有层次关系的链接的集合制作成HTML文件。
     *
     * Main类中使用抽象工厂生产零件并将零件组装成产品，
     * Main类中只引用了factory包，从这一点可以看出，该类并没有使用任何具体零件，产品和工厂
     *
     */
    public static void main(String[] args) {

        System.out.println("请输入实现类类名");
        System.out.println("com.wf.charpter08.book.listfactory.ListLink/ListFactory/ListPage/ListTray");
        Scanner scanner = new Scanner(System.in);
        String className= scanner.next();

        Factory factory = Factory.getFactory(className);

        Link people  = factory.createLink("人民日报","www.people.com.cn");
        Link gmw = factory.createLink("光明日报","www.gmw.cn");

        Link us_yahoo = factory.createLink("Yahoo!","www.yahoo.com");
        Link jp_yahoo = factory.createLink("Yahoo!Japan","www.yahoo.co.jp");
        Link excite = factory.createLink("EXCITE!","www.excite.com");
        Link google = factory.createLink("Google!","www.google.com");

        Tray trayNews = factory.createTray("日报");
        trayNews.add(people);
        trayNews.add(gmw);

        Tray trayYahoo = factory.createTray("Yahoo");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(jp_yahoo);

        Tray traySearch = factory.createTray("搜索引擎");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);


        Page page= factory.createPage("Link Page","wangfa");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }



}
