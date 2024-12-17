package com.wf.charpter21.proxy;

/**
 * @Author: wangfa
 * @Date: 2020/3/25 22:08
 * @Description: 对这个目标对象实现增强代理
 */
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public void selectStudent() {
        System.out.println("查询学生中");
    }


    @Override
    public Integer getAge(Integer id, Integer age) {
        System.out.println("得到年龄中"+id+"--"+age);
        return age;
    }
}
