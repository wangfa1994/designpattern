package com.wf.charpter02.book.extendadapter;

/**
 * @Author: wangfa
 * @Date: 2019/9/28 17:20
 * @Description:  实际情况
 */
public class Banner  {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    /**
     *
     * @Author: wangfa
     * @Date: 2019/9/28 下午5:22
     * @Description:
     */
    public void showWithParen(){
        System.out.println("("+string+")");
    }

    public void showWithAster(){
        System.out.println("*"+string+"*");
    }


}
