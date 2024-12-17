package com.wf.charpter04.dahua.a02;

import com.wf.charpter04.dahua.a02.framework.Operation;

//对数运算类，求以numberA为底的numberB的对数
public class Log extends Operation {

    public double getResult(double numberA, double numberB){
        //此处缺两参数的有效性检测
        return Math.log(numberB)/Math.log(numberA);
    }
    
}

