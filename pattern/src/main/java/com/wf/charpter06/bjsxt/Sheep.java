package com.wf.charpter06.bjsxt;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 16:01
 * @Description:
 */
public class Sheep implements Cloneable,Serializable {

    private String name;
    private Date birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object clone = super.clone();
        return clone;
    }

}
