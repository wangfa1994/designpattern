package com.wf.charpter09.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/25 16:00
 * @Description:
 */
public class Pad extends Computer {

    public Pad(Brand brand) {
        super(brand);
    }


    @Override
    public void sale() {
        super.sale();
        System.out.println("平板");
    }
}
