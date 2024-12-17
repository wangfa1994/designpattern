package com.wf.charpter08.dahua.a02;

//Access工厂
public class AccessFactory implements IFactory {

    public IUser createUser(){
        return new AccessUser();
    }

}

