package com.wf.charpter16.book;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 14:10
 * @Description:
 */
public class ColleagueTextField extends TextField implements Colleague,TextListener {

    private Mediator mediator;

    public ColleagueTextField(String text, int columns) throws HeadlessException {
        super(text, columns);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled?Color.white:Color.lightGray);
    }


    /**
     *  实现TextListener捕获文本内容变化，通知仲裁者，我进行了改变
     */
    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
