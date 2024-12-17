package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 18:27
 * @Description: 只解决指定编号的问题
 */
public class SpecialSupport extends Support {

    // 只解决指定编号的问题
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {

        // 解决问题的办法，只是简单的返回true，但实际上这里应该是解决问题的代码
        if(trouble.getNumber() == number){
            return true;
        }
        return false;
    }
}
