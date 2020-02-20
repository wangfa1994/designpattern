package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 18:19
 * @Description: 解决编号小于limit值的问题。
 *
 */
public class LimitSupport extends  Support {


    // 可以解决编号小于limit的问题
    private int limit;


    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // resolve方法在判断编号小于limit值后，只是简单的返回true，但实际上这里应该是解决问题的代码
        if (trouble.getNumber()<limit){
            return true;
        }
        return false;
    }
}
