package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 18:23
 * @Description:
 */
public class OddSupport extends Support {


    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // 解决问题的办法，只是简单的返回true，但实际上这里应该是解决问题的代码
        if(trouble.getNumber() %2 ==1){
            return true;
        }
        return false;
    }
}
