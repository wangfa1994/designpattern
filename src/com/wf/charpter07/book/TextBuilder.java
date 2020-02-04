package com.wf.charpter07.book;

/**
 * @Author: wangfa
 * @Date: 2019/11/3 16:41
 * @Description: 使用纯文本编写文档的类，继承了Builder类,实现了各个部分的编写的逻辑
 * <p>
 * 使用纯文本
 */
public class TextBuilder extends Builder {

    private StringBuffer buffer = new StringBuffer();


    @Override
    public void makeTitle(String title) {
        buffer.append("===========================\n");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");

    }

    @Override
    public void makeString(String string) {
        buffer.append('*' + string + "\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {

        for (String item : items) {
            buffer.append("~" + item + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("===========================\n");
    }

    // 完成文档得到结果
    public String getResult(){
        return buffer.toString();
    }

}
