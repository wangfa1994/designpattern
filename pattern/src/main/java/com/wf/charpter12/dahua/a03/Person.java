package com.wf.charpter12.dahua.a03;

//具体人类
public class Person implements ICharacter {

	private String name;
    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的"+name);
    }
}



