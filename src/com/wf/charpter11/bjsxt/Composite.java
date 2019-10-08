package com.wf.charpter11.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/25 16:23
 * @Description: 容器
 */
public interface Composite extends   Component {

   void  add(Component component);
   void remove(Component component);
   Component getChild(int index);
}
