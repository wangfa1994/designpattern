package com.wf.charpter01.bjsxt;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangfa
 * @Date: 2019/9/29 16:26
 * @Description: 自定义的聚合类
 */
public class ConcreteMyAggregate {


    private List<Object> list = new ArrayList<>();


    public void addObject(Object object){
        list.add(object);
    }

    public void deleteObject(Object object){
        list.remove(object);

    }


    public MyIterator getIterator(){
        return  new ConcreteIterator();
    }



    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }





    // 使用内部类的自定义迭代器，可以直接使用外部属性
    private class ConcreteIterator implements MyIterator{

        // 定义游标用于记录遍历时的位置
        private int cursor;



        @Override
        public void first() {
            cursor = 0;

        }

        @Override
        public void next() {
            if((cursor<list.size())){
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            if(cursor< list.size()){
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isEnd() {
            return cursor == list.size();
        }

        @Override
        public Object getCurrentObject() {
            return  list.get(cursor);
        }
    }
}
