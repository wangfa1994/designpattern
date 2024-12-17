package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 18:17
 * @Description:
 */
public class NoSupport extends Support {


    public NoSupport(String name) {
        super(name);
    }


    // 解决问题的方法，自己什么也不处理
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }



}
