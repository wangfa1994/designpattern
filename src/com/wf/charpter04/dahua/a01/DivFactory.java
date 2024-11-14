package com.wf.charpter04.dahua.a01;

import com.wf.charpter04.dahua.a01.framework.IFactory;
import com.wf.charpter04.dahua.a01.framework.Operation;

//除法工厂
public class DivFactory implements IFactory {

    public Operation createOperation(){
        return new Div();
    }
    
}
