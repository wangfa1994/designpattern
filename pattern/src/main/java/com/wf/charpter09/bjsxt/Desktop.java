package com.wf.charpter09.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/25 15:58
 * @Description:
 */
public class Desktop extends Computer {


    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("台式");
    }
}
