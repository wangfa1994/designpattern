package com.wf.charpter09.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/25 15:57
 * @Description:
 */
public class Computer {

    private Brand brand;


    public Computer(Brand brand) {
        this.brand = brand;
    }


    public void sale(){
        brand.sale();
    }
}
