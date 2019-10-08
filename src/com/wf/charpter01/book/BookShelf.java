package com.wf.charpter01.book;

/**
 * @Author: wangfa
 * @Date: 2018/12/22 10:13
 * @Description:  表示书架的类，由于需要将该类作为集合进行处理，所以需要实现Aggregate,用来生成迭代器
 *
 * 具体的集合
 *
 */
public class BookShelf implements Aggregate {

    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }


    public Book getBookAt(int index){
        return books[index];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }

    public int getLength(){
        return  last;
    }

    @Override
    public Iterator iterator() {
        // 生成并返回 BookShelfIterator 类的实例作为BookShelf 类对应的Iterator。想要遍历书架，就调用这个方法
        return new BookShelfIterator(this);
    }
}
