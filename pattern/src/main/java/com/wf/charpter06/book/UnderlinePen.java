package com.wf.charpter06.book;

import com.wf.charpter06.book.framework.Product;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 10:03
 * @Description: 给字符串加上下划线并使其显示出来的类。实现了use方法和createClone方法
 */
public class UnderlinePen implements Product {

    private String ulchar;

    public UnderlinePen(String ulchar) {
        this.ulchar = ulchar;
    }



    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\""+ s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }

        System.out.println(" ");


    }

    @Override
    public Product createClone() {

        Product p  = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }
}
