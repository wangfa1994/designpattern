package com.wf.charpter11.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/5 18:06
 * @Description: 表示向文件中增加Entry时发生的异常的类
 */
public class FileTreatementException extends RuntimeException {

    public FileTreatementException() {
    }

    public FileTreatementException(String msg){
        super(msg);
    }
}
