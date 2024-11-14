package com.wf.charpter04.dahua.a02;

import com.wf.charpter04.dahua.a02.framework.IFactory;
import com.wf.charpter04.dahua.a02.framework.Operation;

//基础运算工厂
public class FactoryBasic implements IFactory {

    public Operation createOperation(String operType){
        Operation oper = null;
        switch (operType) {
            case "+":
                oper = new Add();
                break;
            case "-":
                oper = new Sub();
                break;
            case "*":
                oper = new Mul();
                break;
            case "/":
                oper = new Div();
                break;
        }
                
        return oper;
    }
    
}


