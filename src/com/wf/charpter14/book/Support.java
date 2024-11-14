package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 18:04
 * @Description: 用来解决问题的抽象类，属于责任链上的对象
 */
public abstract class Support {

    private String name;

    //指定要推卸给的对象
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    // 设置要推卸给的对象
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }


    // 解决问题的方法 抽象方法
    protected abstract boolean resolve(Trouble trouble);


    // 模板方法
    public final void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }else if (next!=null){
            next.support(trouble);
        }else{
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 属于自己的独有方法
    protected void done(Trouble trouble){ // 解决
        System.out.println(trouble+"is resolved by"+this+"..");
    }


    // 属于自己的独有方法
    protected void fail(Trouble trouble){ // 未解决
        System.out.println(trouble+"cannot be resolved..");
    }
}
