package com.wf.charpter01.book;

/**
 * @Author: wangfa
 * @Date: 2018/12/22 09:44
 * @Description: 遍历集合的接口
 * 其作用相当于循环语句中的循环变量。
 * Iterator接口的定义方法有很多种，我们这里编写了最简单的Iterator接口
 *
 */
public interface Iterator {

    /**
     * 判断是否存在下一个元素的hasNext方法，hasNext主要用于循环终止条件
     *
     */
    boolean hasNext();

    /**
     * 返回集合中的一个元素，
     * 注意，为了能够在下一次调用next方法正确的返回下一个元素，该方法中还隐含着将迭代器移动至下一个元素的处理。
     * 想要知道next的处理，我们还需要看下实现Iterator接口的实现类(BookShelfIterator)
     */
    Object next();
}
