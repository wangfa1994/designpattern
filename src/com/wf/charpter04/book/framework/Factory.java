package com.wf.charpter04.book.framework;

/**
 * @Author: wangfa
 * @Date: 2019/10/9 19:10
 * @Description: 实现了create方法的抽象类
 *
 * 我们定义工厂是用来调用create方法生成Product实例。
 * （模板方法）
 */
public abstract class Factory {


    // 模板方法
    public final Product create (String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String owner);


    protected abstract void registerProduct(Product product);

}
