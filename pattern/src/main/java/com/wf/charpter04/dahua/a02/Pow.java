package com.wf.charpter04.dahua.a02;

import com.wf.charpter04.dahua.a02.framework.Operation;

//指数运算类，求numberA的numberB次方
public class Pow extends Operation {

    public double getResult(double numberA, double numberB){
        //此处缺两参数的有效性检测
        return Math.pow(numberA,numberB);
    }
    
}


