package com.wf.charpter04.book.idcard;

import com.wf.charpter04.book.framework.Factory;
import com.wf.charpter04.book.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2019/10/9 19:18
 * @Description: 实现了 createProduct registerProduct 方法的类
 *
 *
 * createProduct 方法通过生成IDCard的实例来 "生产产品"
 * registerProduct 方法通过将IdCard的 owner(持有人)保存到对应的owner字段中来是实现产品注册
 *
 */
public class IDCardFactory  extends Factory{

    private List<String> owners = new ArrayList<>();


    @Override
    protected Product createProduct(String owner) {

        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }


    public List<String> getOwners() {
        return owners;
    }
}
