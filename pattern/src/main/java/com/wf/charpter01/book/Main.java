package com.wf.charpter01.book;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2018/12/22 09:41
 * @Description: Iterator
 * 迭代器模式------》一个一个遍历
 *
 * 通用的for-i循环，在for循环中i++的作用是让i的值每次循环加一，这样就可以访问数组中的下一个元素，也就是实现了数组的遍历。
 * 将循环变量i,进行抽象化，通用化之后形成的模式，在设计模式中叫做Iterator模式。
 * 迭代器模式用于在数据集合中按照顺序遍历集合。
 *
 *
 */


public class Main {
    /*eg: 将书(Book)放置到书架(BookShelf)中，并将数的名字按照顺序显示出来
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
