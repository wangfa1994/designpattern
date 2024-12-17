package com.wf.charpter16.book;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 14:10
 * @Description:
 */
public class ColleagueCheckbox extends Checkbox implements Colleague,ItemListener{

    private Mediator mediator;

    public ColleagueCheckbox(String label, CheckboxGroup group, boolean state) throws HeadlessException {
        super(label, group, state);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }



    @Override
    public void setColleagueEnabled(boolean enabled) {
            setEnabled(enabled);
    }

    /**
     * 状态发生改变，进行通知仲裁者
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
