package com.wf.charpter04.dahua.a02;

import com.wf.charpter04.dahua.a02.framework.Operation;

public class Div extends Operation {
    public double getResult(double numberA, double numberB){
        if (numberB == 0){
            System.out.println("除数不能为0");
            throw new ArithmeticException();
        }
        return numberA / numberB;
    }
}
