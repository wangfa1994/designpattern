package com.wf.charpter04.dahua.a01;

import com.wf.charpter04.dahua.a01.framework.IFactory;
import com.wf.charpter04.dahua.a01.framework.Operation;

//乘法工厂
public class MulFactory implements IFactory {

    public Operation createOperation(){
        return new Mul();
    }
    
}
