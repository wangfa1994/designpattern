package com.wf.charpter21.bjsxt.commonDynamicProxy;

public class XiaoWangStudent implements StudentInterface {
    @Override
    public String study(String name) {
        System.out.println("小王正在学习...");
        return name;
    }
}
