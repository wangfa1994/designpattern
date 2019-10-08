package com.wf.charpter01.book;

/**
 * @Author: wangfa
 * @Date: 2018/12/22 10:20
 * @Description: 遍历书架的BookShelfIterator
 */
public class BookShelfIterator implements Iterator {

    private  BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index<bookShelf.getLength()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
