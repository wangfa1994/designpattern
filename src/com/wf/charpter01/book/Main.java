package com.wf.charpter01.book;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2018/12/22 09:41
 * @Description: 迭代器模式
 */
public class Main {
    /**
     *  迭代器模式用于在数据集合中按照顺序遍历集合
     */
    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf(10);
        bookShelf.appendBook(new Book("数据结构"));
        bookShelf.appendBook(new Book("网页设计"));
        bookShelf.appendBook(new Book("算法分析"));
        bookShelf.appendBook(new Book("设计模式"));
        bookShelf.appendBook(new Book("Abs"));

        Iterator iterator = bookShelf.iterator();

        while (iterator.hasNext()){
            Book book  = (Book) iterator.next();
            System.out.println(book.getName());
        }

        javaIterator();

    }



    private static  void javaIterator(){
        System.out.println("============");
        List<Book> books = new ArrayList<>(4);
        books.add(new Book("设计模式"));
        books.add(new Book("算法分析"));
        books.add(new Book("网页设计"));
        books.add(new Book("数据结构"));
        java.util.Iterator iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }

}
