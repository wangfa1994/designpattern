package com.wf.charpter04.book.framework;

/**
 * @Author: wangfa
 * @Date: 2019/10/9 19:10
 * @Description: 实现了create方法的抽象类
 *
 * 我们定义工厂是用来调用create方法生成Product实例。
 * （模板方法）
 *
 *
 *
 *
 *
 */
public abstract class Factory {


    /**
     *    模板方法
     *    只要是Factory Method模式，在生成实例时就一定会使用到Template Method 模式
      */

    public final Product create (String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }


    /**
     * 生产产品的抽象方法
     */
    protected abstract Product createProduct(String owner);


    /**
     *  注册产品的抽象方法
     */
    protected abstract void registerProduct(Product product);


    /**
     * 工厂方法模式中，一定会存在工厂的抽象和产品的抽象，然后我们利用抽象的工厂去创建抽象的产品，然后将所有的内容交给子类实现
     *
     *
     */
}
