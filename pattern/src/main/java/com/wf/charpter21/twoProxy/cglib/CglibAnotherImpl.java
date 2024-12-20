package com.wf.charpter21.twoProxy.cglib;

public class CglibAnotherImpl implements CglibAnother{

    @Override
    public String anotherEcho(String s) {
        System.out.println("进入了原始对象anotherEcho");
        return s;
    }
}
