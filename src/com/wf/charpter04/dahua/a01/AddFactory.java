package com.wf.charpter04.dahua.a01;

import com.wf.charpter04.dahua.a01.framework.IFactory;
import com.wf.charpter04.dahua.a01.framework.Operation;

//加法工厂
public class AddFactory implements IFactory {

    public Operation createOperation(){
        return new Add();
    }
    
}
