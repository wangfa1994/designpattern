package com.wf.charpter21.twoProxy.cglib;

public class CglibEcho {

    public String echo(String s){
        System.out.println("进入了原始对象echo");
        return s;
    }

    public String echo1(String s){
        System.out.println("进入了原始对象echo1");
        return s;
    }
}
