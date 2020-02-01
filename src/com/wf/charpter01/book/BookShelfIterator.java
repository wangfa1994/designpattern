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


    /**
     * 要知道书架中是否还存在下一本书，可以通过比较index和书架中书的总册数来进行判断
     *
     */
    @Override
    public boolean hasNext() {
        if(index<bookShelf.getLength()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * next方法会返回迭代器中当前所指向的书，并让迭代器指向下一本书，
     * 先取出当前book变量作为返回值，然后让index指向下一本书，(相当于i++,让循环变量指向下一个元素)
     */
    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
