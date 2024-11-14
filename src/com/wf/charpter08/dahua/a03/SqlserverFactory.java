package com.wf.charpter08.dahua.a03;

//Sqlserver工厂
public class SqlserverFactory implements IFactory {

    public IUser createUser(){
        return new SqlserverUser();
    }
    
    public IDepartment createDepartment(){
        return new SqlserverDepartment();
    }
    
}

