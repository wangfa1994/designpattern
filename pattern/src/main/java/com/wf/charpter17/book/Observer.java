package com.wf.charpter17.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 17:00
 * @Description: 观察者的接口
 *
 * 具体的观察者会实现这个接口，需要注意的是和java.util.Observer类的区别
 * 我们的这个Observer接口是为了理解Observer模式而编写的
 *
 *  *
 * 用于生成数值的NumberGenerator类会调用update方法，
 * 如果调用update方法，NumberGenerator类就会将"生成的数值发生了变化，请更新显示内容"的通知发送给Observer
 *
 */
public interface Observer {

    void update(NumberGenerator numberGenerator);


}
