package com.wf.charpter21.proxy;

/**
 * @Author: wangfa
 * @Date: 2020/3/25 22:07
 * @Description:
 */
public interface TeacherDao {

    void selectStudent();

    Integer getAge(Integer id,Integer age);
}
