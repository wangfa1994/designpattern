package com.wf.charpter06.book;

import com.wf.charpter06.book.framework.Product;

/**
 * @Author: wangfa
 * @Date: 2019/10/20 10:02
 * @Description: 将字符串放入方框中并使其显示出来的类。实现了use方法和createClone方法
 */
public class MessageBox  implements Product{


    private String decochar;

    public MessageBox(String decochar) {
        this.decochar = decochar;
    }



    @Override
    public void use(String s) {

        int length = s.getBytes().length;
        for (int i = 0; i < length+4; i++) {
            System.out.print(decochar);
        }

        System.out.println("");
        System.out.println(decochar + " " + s +" "+ decochar);


        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");

    }

    @Override
    public Product createClone() {

        Product p = null;

        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }
}
