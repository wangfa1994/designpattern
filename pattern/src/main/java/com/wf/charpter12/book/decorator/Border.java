package com.wf.charpter12.book.decorator;

import com.wf.charpter12.book.componet.Display;

/**
 * @Author: wangfa
 * @Date: 2019/10/28 19:31
 * @Description: 用于显示装饰边框的抽象类
 *
 * 虽然他所表示的是装饰边框，但是他也是Display的子类，也就是说，通过继承，装饰边框与被装饰者具有了相同的方法
 * 从接口(API)角度，装饰边框(Border)与被装饰物(Display)具有相同的方法也就意味着他们具有一致性
 */
public abstract class Border extends Display {

    // 表示被装饰物 注意修饰符
    protected Display display;


    public Border(Display display) {
        this.display = display;
    }
    /**
     * display字段所表示的被装饰物并不仅限于StringDisplay的实例，
     * 因为，Border也是Display的子类，display字段所表示的也可能是其他的装饰边框，Border类的子类的实例，而且那个边框也有一个display字段
     */
}
